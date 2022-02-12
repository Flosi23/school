package dictionary.dictionary;

import java.util.Locale;

public class Entry implements Comparable<Entry>{

    static String foreignLanguage;
    static String translationLanguage;
    static String explanationString;
    static String noExplanationString;

    private final String foreignWord;
    private final String translation;
    private final String explanation;
    // Diese Variable beinflusst ob beim sortieren
    // die Fremdwörter oder die Übersetzungen verglichen werden
    private final boolean compareForeign;

    public Entry(String foreignWord, String translation, boolean compareForeign){
        this.foreignWord = foreignWord.trim();
        this.translation = translation.trim();
        this.explanation = noExplanationString;
        this.compareForeign = compareForeign;
    }

    public Entry(String foreignWord, String translation, String explanation, boolean compareForeign){
       this.foreignWord = foreignWord.trim();
       this.translation = translation.trim();
       this.explanation = explanation.trim();
       this.compareForeign = compareForeign;
    }

    public static String getForeignLanguage() {
        return foreignLanguage;
    }

    public static String getTranslationLanguage() {
        return translationLanguage;
    }

    public static String getExplanationString() {
        return explanationString;
    }

    public String getForeignWord() {
        return foreignWord;
    }

    public String getTranslation() {
        return translation;
    }

    public String getExplanation() {
        return explanation;
    }

    /**
     * Beim comparen verwenden wir toLowerCase um sicherzustellen,
     * dass die Entrys alphabetisch sortiert werden
     */
    @Override
    public int compareTo(Entry o) {
        if(compareForeign) {
            return this.foreignWord.toLowerCase(Locale.ROOT).compareTo(o.foreignWord.toLowerCase(Locale.ROOT));
        }
        return this.translation.toLowerCase(Locale.ROOT).compareTo(o.translation.toLowerCase(Locale.ROOT));
    }

    /**
     Einträge werden als gleich angesehen, wenn
     entweder das foreignWord oder die translation miteinander
     übereinstimmen. Das ermöglicht, dass in beiden Sprachen gesucht
     werden kann
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return foreignWord.toLowerCase(Locale.ROOT).equals(entry.foreignWord.toLowerCase(Locale.ROOT))
                || translation.toLowerCase(Locale.ROOT).equals(entry.translation.toLowerCase(Locale.ROOT));
    }

    @Override
    public String toString(){
        return "\n" + foreignLanguage + ": " + foreignWord + "\n"
        + translationLanguage + ": " + translation + "\n"
        + explanationString + ": " + explanation + "\n";
    }

    public String toCSVFormat(){
        return foreignWord + ";" + translation + ";" + explanation;
    }

    public static Entry fromCSVFormat(String line){
        String[] split = line.split(";");

        if(split.length < 2 || split.length > 3){
            throw new IllegalArgumentException("Line must have 2 or 3 columns");
        }

        String[] englishWords = split[0].split(",");
        String[] germanWords = split[1].split(",");

        if(split.length == 3){
            String explanation = split[2];
            return new Entry(englishWords[0], germanWords[0], explanation, true);
        } else {
            return new Entry(englishWords[0], germanWords[0], true);
        }
    }
}
