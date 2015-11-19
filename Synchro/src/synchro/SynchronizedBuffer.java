/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author:  Jonathan Lundstrom
 */
package synchro;

/**
 *
 * @author Jonathan
 */
public class SynchronizedBuffer {
    public String Data = "NIL";
    private boolean occupied = false;
    
    //public synchronized Object occupied;
    
    public synchronized void setString(String str) throws InterruptedException{
        int w = 1;
        while (occupied) {
            System.out.printf("%1$-30s %2$-9s %3$-10s\n\n", 
                    "Producer wait # " + w, Data, occupied);
            wait();
            w += 1;
        }
        Data = str;
        occupied = true;
        System.out.printf("Producer writes: %s\n\n", str);
        notifyAll();
    }
    
     public synchronized String getString() throws InterruptedException{
         int w = 1;
         while(!occupied) {
            System.out.printf("%1$-30s %2$-9s %3$-10s\n\n", 
                    "Consumer wait # " + w, Data, occupied);
            wait();
            w += 1;
         }
         String rtnBuff = Data;
         occupied = false;
         notifyAll();
         
         System.out.printf("Consumer reads: %s\n\n", rtnBuff);
         return rtnBuff;
    }
}