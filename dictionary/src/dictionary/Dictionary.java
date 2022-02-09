package dictionary;

import dictionary.BST.BST;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Dictionary {

    private static final String FILE_PATH = "vocabulary.csv";

    private final BST<Entry> foreignDB;
    private final BST<Entry> translatedDB;

    public Dictionary(){
        foreignDB = new BST<>();
        translatedDB = new BST<>();
        Entry.foreignLanguage = "Englisch";
        Entry.translationLanguage = "Deutsch";
        Entry.explanationString = "Erklärung";
        Entry.noExplanationString = "Keine Erklärung vorhanden";
    }

    public void list(){
        foreignDB.list();
    }

    public List<Entry> toList(){
        return foreignDB.toList();
    }

    public int size(){
        return foreignDB.size();
    }

    public void add(String foreignWord, String translation, String explanation){
        foreignDB.insert(new Entry(foreignWord, translation, explanation, true));
        translatedDB.insert(new Entry(foreignWord, translation, explanation, false));
    }

    public void remove(String query){
        Entry entry = search(query);

        if(entry == null){
            return;
        }

        foreignDB.remove(new Entry(entry.getForeignWord(), entry.getTranslation(), entry.getExplanation(), true));
        translatedDB.remove(new Entry(entry.getForeignWord(), entry.getTranslation(), entry.getExplanation(), false));
    }

    public Entry search(String query){
        Entry foreignDBResult = foreignDB.search(new Entry(query, query, true));
        Entry translatedDBResult = translatedDB.search(new Entry(query,query, false));
        return foreignDBResult == null ? translatedDBResult : foreignDBResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictionary that = (Dictionary) o;
        return Objects.equals(foreignDB, that.foreignDB) && Objects.equals(translatedDB, that.translatedDB);
    }

    public static Dictionary fromCSVFile(){
        Dictionary dictionary = new Dictionary();
        List<Entry> entries = Parser.parseCSVFile(FILE_PATH);

        Collections.shuffle(entries);

        for(Entry entry : entries){
            dictionary.add(entry.getForeignWord(), entry.getTranslation(), entry.getExplanation());
        }

        return dictionary;
    }
}
