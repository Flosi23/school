package dictionary;

import dictionary.dictionary.Dictionary;
import dictionary.gui.GUI;

public class Main {

    public static void main(String[] args) {
        Cache.init();
        Dictionary dictionary = Dictionary.fromCache();
        FetchThread.fetchWords(dictionary, Texts.getAllWords());
        GUI.startGUI(dictionary);
    }
}
