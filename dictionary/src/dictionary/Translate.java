package dictionary;

import dictionary.dictionary.Entry;
import dictionary.util.Http;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class Translate {

    private static String parseTranslation(String response) {
        System.out.println("response: " + response);
        var regexp = Pattern.compile("\"translatedText\":\"(?<translation>.*?)\"").matcher(response);
        if (!regexp.find())
            return null;

        return regexp.group("translation");
    }

    private static String parseDefinition(String response) {
        var regexp = Pattern.compile("\"definition\":\"(?<definition>.*?)\"").matcher(response);
        if (!regexp.find())
            return null;
        return regexp.group("definition");
    }

    public static Entry translate(String query) throws Exception {
        String queryTranslation = parseTranslation(
                Http.post("https://libretranslate.de/translate", "q=" + query + "&source=en&target=de"));
        if (queryTranslation == null)
            queryTranslation = query;
        String queryDefinition = parseDefinition(
                Http.get("https://api.dictionaryapi.dev/api/v2/entries/en_US/" + query, ""));
        if (queryDefinition == null)
            queryDefinition = query;
        return new Entry(query, queryTranslation, queryDefinition, true);
    }
}
