package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {
    private ReentrantLock safe= new ReentrantLock();
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        safe.lock();
        while(stringIterator.hasNext()){
            try {
                Thread.currentThread().sleep(10);
                if(stringIterator.hasNext()){copied+=" "+stringIterator.next();}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } safe.unlock();
    }

    public String getCopy(){
        System.out.println("\n\n\nTHE GOOD ONE\n\n\n");
        return copied;}
}
