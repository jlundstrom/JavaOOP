/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author:  Jonathan Lundstrom
 */
package synchro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Jonathan
 */
public class SynchroTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SynchronizedBuffer sb = new SynchronizedBuffer();
        
        Consumer con = new Consumer(sb);
        Producer pro = new Producer(sb);
        
        System.out.println("COP3330 (Fall 2015) Program 8: Synchronized Buffer");
        System.out.println("Author: Jonathan Lundstrom\n");
        
        System.out.printf("%1$-30s %2$-9s %3$-10s\n", "Operation", "Buffer", "Occupied");
        System.out.printf("%1$-30s %2$-9s %3$-10s\n", "---------", "------", "--------");
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        executorService.execute(con);
        executorService.execute(pro);
        
        executorService.shutdown();
    }
    
}
