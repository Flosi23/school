package dictionary.gui.model;

import dictionary.dictionary.Dictionary;
import dictionary.dictionary.Entry;
import dictionary.Cache;

import java.util.LinkedList;
import java.util.List;

public class AdminModel {

    private final Dictionary dictionary;
    private List<Entry> entries;
    private int numberOfLoadedEntries;

    private static final int BATCH_SIZE = 100;

    public AdminModel(Dictionary dictionary){
        this.dictionary = dictionary;
    }

    public List<Entry> getNextBatch(){
        if(entries == null){
            return new LinkedList<>();
        }

        int newNumber = Math.min(numberOfLoadedEntries + BATCH_SIZE, entries.size());

        List<Entry> output = entries.subList(numberOfLoadedEntries, newNumber);
        numberOfLoadedEntries = newNumber;
        return output;
    }

    public int dictionarySize(){
        return dictionary.size();
    }

    public void loadListOfAllEntries(){
        entries = dictionary.toList();
        numberOfLoadedEntries = 0;
    }

    public void add(String foreignWord, String translation, String explanation){
        dictionary.add(foreignWord, translation, explanation);
        Cache.cache(new Entry(foreignWord, translation, explanation, true));
    }

    public void remove(String query){
        dictionary.remove(query);
    }
}
