package dictionary;

import dictionary.dictionary.Dictionary;
import dictionary.dictionary.Entry;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FetchThread extends Thread{

    private final static int REQUEST_DELAY = 2;
    private final static int NUMBER_OF_THREADS = 4;

    private final Queue<String> words;
    private final Dictionary dictionary;

    public FetchThread(List<String> words, Dictionary dictionary){
        this.words = new PriorityQueue<>(words);
        this.dictionary = dictionary;
    }

    @Override
    public void run() {
        while(!words.isEmpty()) {
            String word = words.poll();

            if(Cache.contains(word)){
                return;
            }

            try {
                Entry entry = Translate.translate(word);
                dictionary.add(entry);
                Cache.cache(entry);
            } catch (Exception ignored){}

            try {
                sleep(REQUEST_DELAY * 1000);
            } catch (InterruptedException ignored){}
        }
    }

    public static void fetchWords(Dictionary dictionary, List<String> words){
        int numThreads = Math.min(NUMBER_OF_THREADS, Math.max(1, words.size()));

        System.out.println(numThreads);

        FetchThread[] fetchThreads = new FetchThread[numThreads];
        List<List<String>> parts = chopIntoParts(words, numThreads);

        for(int i = 0; i < parts.size();i++){
            fetchThreads[i] = new FetchThread(parts.get(i), dictionary);
        }

        for(Thread thread: fetchThreads){
            if(thread == null){
                continue;
            }
            thread.start();
        }
    }

    public static <T> List<List<T>> chopIntoParts(List<T> collection, int batchSize) {
        return IntStream.iterate(0, i -> i < collection.size(), i -> i + batchSize)
                .mapToObj(i -> collection.subList(i, Math.min(i + batchSize, collection.size())))
                .collect(Collectors.toList());
    }
}
