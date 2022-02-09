package school.dictionary;

import school.dictionary.BST.BST;

public class Dictionary {

    private final BST<Entry> db;

    public Dictionary(){
        Entry.setForeignLanguage("English");
        Entry.setForeignLanguage("German");
        Entry.setExplanationString("Erklärung");
        db = new BST<>();
    }

    public void add(String foreignWord, String translation, String explanation){
        db.insert(new Entry(foreignWord, translation, explanation));
    }

    public void remove(String word){
        db.remove(new Entry(word, word))
    }

    public void search(String query){
        Entry result = db.search(new Entry(query, query));
        printSearchResult(result);
    }

    private void printSearchResult(Entry result){
        String string = "Kein Eintrag gefunden";

        if(result != null){
            result.toString();
        }

        System.out.prinln(string);
    }
}
