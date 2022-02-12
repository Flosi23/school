package dictionary.files.cache;

import dictionary.dictionary.Dictionary;
import dictionary.dictionary.Entry;
import dictionary.util.FilesUtil;
import dictionary.util.ReadWriteLock;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;

public class Cache {

    private static final Dictionary cachedEntries = new Dictionary();
    private static boolean initialzed = false;
    private static final String FILE = "cache/cache.csv";
    private static final ReadWriteLock RW = new ReadWriteLock();

    public static void init(){
        RW.startWrite();

        Stream<String> lines = FilesUtil.getFileLines(new File(FILE));

        if(lines == null){
            RW.stopWrite();
            return;
        }

        lines.map(l -> l.replaceAll("\\([^()]*\\)", ""))
                .forEach(l -> cachedEntries.add(Entry.fromCSVFormat(l)));

        initialzed = true;

        RW.stopWrite();
    }

    private static void lazy(){
        RW.startRead();

        if(!initialzed){
            RW.stopRead();
            init();
            return;
        }

        RW.stopRead();
    }

    public static boolean contains(Entry entry){
        lazy();
        return cachedEntries.contains(entry);
    }

    public synchronized static void cache(Entry entry){
        lazy();

        if(contains(entry)){
            return;
        }

        RW.startWrite();

        File file = new File(FILE);
        FilesUtil.writeToFile(file, "\n" + entry.toCSVFormat());

        RW.stopWrite();

        cachedEntries.add(entry);
    }

    public static List<Entry> getCachedEntries(){
        return cachedEntries.toList();
    }
}
