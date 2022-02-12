package dictionary.dictionary;

import dictionary.dictionary.BST.BST;
import dictionary.files.cache.Cache;
import dictionary.util.ReadWriteLock;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Dictionary {

    /**
     * Damit man sowohl nach dem Fremdwort als auch nach der Übersetzung
     * suchen kann, ist es erfoderlich 2 BSTs zu erstellen, wo in dem einem
     * nach dem Fremdwort und in dem anderem nach der Übersetzung sortiert wird
     *
     * Beim einfügen sowie beim entfernen in das Wörterbuch wird in beide Bäume eingefügt /
     * aus beiden Bäumen entfernt
     *
     * Das Dictionary wird mithile eines ReadWrite-Locks Thread safe gemacht, damit es möglich ist,
     * die im Fremdsprachentext enthaltenen Wörter mit mehreren Threads gleichzeitig im Internet nachzuschlagen
     * und in das Dictionary einzufügen
     */
    private final BST<Entry> foreignDB;
    private final BST<Entry> translatedDB;
    private final ReadWriteLock RW;

    public Dictionary(){
        foreignDB = new BST<>();
        translatedDB = new BST<>();
        RW = new ReadWriteLock();

        Entry.foreignLanguage = "Englisch";
        Entry.translationLanguage = "Deutsch";
        Entry.explanationString = "Erklärung";
        Entry.noExplanationString = "Keine Erklärung vorhanden";
    }

    public void list(){
        RW.startRead();
        foreignDB.list();
        RW.stopRead();
    }

    public boolean contains(Entry entry){
        RW.startRead();

        boolean containsForeign = foreignDB.contains(entry);
        boolean containsTranslate = translatedDB.contains(entry);

        synchronized (this) {
            RW.stopRead();
            return containsForeign || containsTranslate;
        }
    }

    public List<Entry> toList(){
        RW.startRead();

        List<Entry> list = foreignDB.toList();

        synchronized (this) {
            RW.stopRead();
            return list;
        }
    }

    public int size(){
        RW.startRead();

        int size = foreignDB.size();

        synchronized (this) {
            RW.stopRead();
            return size;
        }
    }

    public void add(Entry entry){
        add(entry.getForeignWord(), entry.getTranslation(), entry.getExplanation());
    }

    public void add(String foreignWord, String translation, String explanation){
        RW.startWrite();

        foreignDB.insert(new Entry(foreignWord, translation, explanation, true));
        translatedDB.insert(new Entry(foreignWord, translation, explanation, false));

        RW.stopWrite();
    }

    public void remove(String query){
        RW.startWrite();

        Entry entry = nonSynchronizedSearch(query);

        if(entry == null){
            return;
        }

        foreignDB.remove(new Entry(entry.getForeignWord(), entry.getTranslation(), entry.getExplanation(), true));
        translatedDB.remove(new Entry(entry.getForeignWord(), entry.getTranslation(), entry.getExplanation(), false));

        RW.stopWrite();
    }

    public Entry search(String query){
        RW.startRead();

        Entry search = nonSynchronizedSearch(query);

        synchronized (this){
            RW.stopRead();
            return search;
        }
    }

    private Entry nonSynchronizedSearch(String query){
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

    public static Dictionary fromCache(){
        Dictionary dictionary = new Dictionary();
        List<Entry> entries = Cache.getCachedEntries();

        Collections.shuffle(entries);

        for(Entry entry : entries){
            dictionary.add(entry);
        }

        return dictionary;
    }

}
