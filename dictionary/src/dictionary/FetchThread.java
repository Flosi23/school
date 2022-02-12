package dictionary;

import dictionary.dictionary.Dictionary;
import dictionary.dictionary.Entry;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
        int numThreads = Math.min(NUMBER_OF_THREADS, words.size());

        FetchThread[] fetchThreads = new FetchThread[numThreads];
        List<List<String>> parts = chopIntoParts(words, numThreads);

        for(int i = 0; i < numThreads;i++){
            fetchThreads[i] = new FetchThread(parts.get(i), dictionary);
        }

        for(Thread thread: fetchThreads){
            thread.start();
        }
    }


    public static <T>List<List<T>> chopIntoParts( final List<T> ls, final int iParts )
    {
        final List<List<T>> lsParts = new LinkedList<>();
        final int iChunkSize = ls.size() / iParts;
        int iLeftOver = ls.size() % iParts;
        int iTake = iChunkSize;

        for( int i = 0, iT = ls.size(); i < iT; i += iTake )
        {
            if( iLeftOver > 0 )
            {
                iLeftOver--;

                iTake = iChunkSize + 1;
            }
            else
            {
                iTake = iChunkSize;
            }

            lsParts.add( new LinkedList<>( ls.subList( i, Math.min( iT, i + iTake ) ) ) );
        }

        return lsParts;
    }
}
