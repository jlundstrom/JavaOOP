/*
 * University of Central Florida
 * COP3330 - Fall 2015
 * Author:  Jonathan Lundstrom
 */
package synchro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class Producer implements Runnable {

    private final static SecureRandom ranGen = new SecureRandom();
    private final SynchronizedBuffer sb;
    private String[] words = {};
    
    public Producer( SynchronizedBuffer sb) {
        this.sb = sb;

        JFileChooser fDialog = new JFileChooser();
        int returnVal = fDialog.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fDialog.getSelectedFile();
            try {
                Scanner scanner = new Scanner( new FileInputStream(file));
                String line = scanner.nextLine();
                JOptionPane.showMessageDialog(null, "Input sentence:\n" + 
                        line);
                words = line.split("\\s+");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    @Override
    public void run() {
        int delayTotal = 0;
        try {
            for ( String s : words)
            {
                int delay = ranGen.nextInt(1000);
                Thread.sleep(delay);
                delayTotal += delay;
                sb.setString(s);
            }
            sb.setString("@@@");
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("Producer Summary: %s @@@\nTotal wait time: %d milliseconds\n\n",
                String.join(" ", words), delayTotal);
    }
    
}
