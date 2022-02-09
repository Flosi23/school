package dictionary;

import java.util.Collections;
import java.util.List;

public class Main {

    /**
     * Über die Methode Dictionary.fromCSVFile() wird ein Dictionary erstellt,
     * dass schon mit ca 4000 Englisch - Deutsch Wörtern gefüllt ist. Das kann nun
     * hier in der Main Methode beliebig getested werden.
     * Es gibt aber außerdem noch in dem package gui die Klasse StartGUI welche
     * eine Bedienung des Dictionaries über eine GUI ermöglicht
     */
    public static void main(String[] args) {
        Dictionary dictionary = Dictionary.fromCSVFile();
    }
}
