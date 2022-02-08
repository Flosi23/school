package school.dictionary;

import java.util.Objects;

public class Entry implements Comparable<Entry>{

    private String foreignWord;
    private String translation;
    private String explanation;

    public Entry(String foreignWord, String translation){
        this.foreignWord = foreignWord;
        this.translation = translation;
        this.explanation = "";
    }

    public Entry(String foreignWord, String translation, String explanation){
       this.foreignWord = foreignWord;
       this.translation = translation;
       this.explanation = explanation;
    }

    @Override
    public int compareTo(Entry o) {
        return this.foreignWord.compareTo(o.foreignWord);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return foreignWord.equals(entry.foreignWord) || translation.equals(entry.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foreignWord, translation, explanation);
    }
}
