package school.dictionary;

import school.dictionary.BST.BST;

public class Dictionary {

    private final BST<Entry> db;

    public Dictionary(){
        db = new BST<>();
    }

    public void add(Entry e){
        db.insert(e);
    }

    public Entry searchForForeignWord(String foreignWord){
        Entry searchQuery = new Entry(foreignWord, "");
        return db.search(searchQuery);
    }

    public Entry searchForTranslation(String translation){
        Entry searchQuery = new Entry("", translation);
        return db.search(searchQuery);
    }
}
