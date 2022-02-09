package dictionary;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Parser {

    public static List<Entry> parseCSVFile(String filePath){
        Stream<String> lines = getFileLines(filePath);
        List<Entry> entries = new LinkedList<>();

        if(lines == null){
            return entries;
        }

        lines.map(l -> l.replaceAll("\\(.*\\)", ""))
                .forEach(l -> {
                    String[] split = l.split(";");

                    if(split.length == 2) {
                        String[] englishWords = split[0].split(",");
                        String[] germanWords = split[1].split(",");

                        entries.add(new Entry(englishWords[0], germanWords[0], true));
                    }
                });

        return entries;
    }

    private static String getAbsolutePath(String filePath){
        return new File(filePath).getAbsolutePath();
    }

    private static Stream<String> getFileLines(String filePath){
        try{
            return Files.lines(Paths.get(getAbsolutePath(filePath)));
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
