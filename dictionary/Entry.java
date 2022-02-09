package school.dictionary;

import java.util.Objects;

/**
Die gesamte Klasse Entry, sowie alle Methoden (außer Methoden die Objekt-Methoden
überschreiben oder Interface Methoden implementieren) sind protected, damit die Klasse
nicht außerhalb des dictionary package sichtbar ist. 
 */
protected class Entry implements Comparable<Entry>{

    private static String foreignLanguage;
    private static String translationLanguage;
    private static String explanationString;

    private String foreignWord;
    private String translation;
    private String explanation;

    protected Entry(String foreignWord, String translation){
        this.foreignWord = foreignWord;
        this.translation = translation;
        this.explanation = "";
    }

    protected Entry(String foreignWord, String translation, String explanation){
       this.foreignWord = foreignWord;
       this.translation = translation;
       this.explanation = explanation;
    }

    
    protected static void setForeignLanguage(String foreignLanguage){
        this.foreignLanguage = foreignLanguage;
    }

    protected static void setTranslationLanguage(String translationLanguage){
        this.translationLanguage = translationLanguage;
    }

    protected static void setDescriptionString(String explanationString){
        this.explanationString = explanationString;
    }

    /**
     * Beim comparen verwenden wir toLowerCase um sicherzustellen,
     * dass die Entrys alphabetisch sortiert werden
     */
    @Override
    public int compareTo(Entry o) {
        return this.foreignWord.toLowercase().compareTo(o.foreignWord.toLowercase());
    }

    /**
    2 Einträge in 
     */
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

    @Override
    public String toString(){
        return foreignLanguage + ": " + foreignWord + "\n"
        + translationLanguage + ": " + translationLanguage + "\n"
        + explanationString + ": " + explanation;
    }
}
