package dictionary;

import dictionary.dictionary.Dictionary;
import dictionary.files.cache.Cache;
import dictionary.gui.GUI;

public class Main {

    public static void main(String[] args) {
        Cache.init();
        Dictionary dictionary = Dictionary.fromCache();
        GUI.startGUI(dictionary);
    }
}
