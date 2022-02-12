package dictionary.util;

public class ReadWriteLock{
    /**
     * < 0 -> reading
     * > 0 -> writing
     * = 0 -> no thread doing anything
     */
    private int threadCount;

    public ReadWriteLock(){
        threadCount = 0;
    }

    public synchronized void startWrite(){
        while(threadCount != 0){
            try{
                wait();
            } catch (InterruptedException ignored){}
        }
        threadCount--;
    }

    public synchronized void stopWrite(){
        threadCount = 0;
        notifyAll();
    }

    public synchronized void startRead(){
        while(threadCount < 0){
            try {
                wait();
            } catch (InterruptedException ignored){}
        }
        threadCount++;
    }

    public synchronized void stopRead(){
        threadCount--;
        if(threadCount == 0){
            notifyAll();
        }
    }
}
