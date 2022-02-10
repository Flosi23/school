package dictionary;

import java.util.Collections;
import java.util.List;

public class Main {


    private static final String FOLDER_PATH = "csvFiles";

    /**
     * Über die Methode Dictionary.fromCSVFiles() wird ein Dictionary erstellt,
     * dass schon mit ca 6000 Englisch - Deutsch Wörtern gefüllt ist. Das kann nun
     * hier in der Main Methode beliebig getested werden.
     *
     * Es gibt aber außerdem noch in dem package gui die Klasse StartGUI welche
     * eine Bedienung des Dictionaries über eine GUI ermöglicht
     */
    public static void main(String[] args) {
        Dictionary dictionary = Dictionary.fromCSVFiles(FOLDER_PATH);
    }
}
