/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author:  Jonathan Lundstrom
 */
package synchro;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan
 */
public class Consumer implements Runnable {
    private final static SecureRandom ranGen = new SecureRandom();
    private final SynchronizedBuffer sb;
    
    public Consumer(SynchronizedBuffer sb) {
        this.sb = sb;
    }
    
    @Override
    public void run() {
        int delayTotal = 0;
        String word = "";
        StringBuilder Sentence = new StringBuilder();
        while(!"@@@".equals(word)) {
            try {
                int delay = ranGen.nextInt(1000);
                delayTotal += delay;
                Thread.sleep(delay);
                word = sb.getString();
                Sentence.append(word);
                if (!"@@@".equals(word)) 
                    Sentence.append(" ");
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.printf("Consumer Summary: %s\nTotal wait time: %d milliseconds\n\n",
                Sentence, delayTotal);
    }

   
    
}
