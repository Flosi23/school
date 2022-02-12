package dictionary;

import dictionary.util.FilesUtil;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Texts {

    private static final String FOLDER = "texts";

    public static List<String> getAllWords(){
        List<String> words = new LinkedList<>();

        for(File file : FilesUtil.getFilesInFolder(FOLDER)){
            Objects.requireNonNull(FilesUtil.getFileLines(file)).forEach(l -> words.addAll(Arrays.asList(l.split(" "))));
        }

        return words;
    }
}
