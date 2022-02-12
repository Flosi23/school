package dictionary.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class FilesUtil {

    private FilesUtil(){}

    public static List<File> getFilesInFolder(String folder){
        List<File> files = new LinkedList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(new File(folder).getAbsolutePath()))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> files.add(new File(folder + "/" + path.getFileName())));
        } catch (IOException e){
            e.printStackTrace();
        }

        return files;
    }

    public static Stream<String> getFileLines(File file){
        try{
            return Files.lines(Paths.get(file.getAbsolutePath())).filter(s -> !s.isEmpty());
        } catch (IOException e){
            return null;
        }
    }

    public static void writeToFile(File file, String content){
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(file.getAbsolutePath(), true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(content);
        } catch (IOException ignored) {
        }
        finally {
            if(out != null) {
                out.close();
            }
            try {
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException ignored) {}
            try {
                if(fw != null) {
                    fw.close();
                }
            } catch (IOException ignored) {}
        }
    }
}
