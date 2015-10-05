/*
 * University of Central Florida
 * COP330 - Fall 2015
 * Author:  Jonathan Lundstrom
 */
package jacsim;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Jonathan
 */
public class JacSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            Scanner input = new Scanner(new FileInputStream(file));
            List<SortedSet<String>>  Lines = new LinkedList<>();
            
            System.out.println("Input Sentences:\n");
            
            while (input.hasNextLine()) {
                SortedSet<String> sub = new TreeSet();
                String line = input.nextLine();
                
                System.out.printf("%d : %s\n", Lines.size(), line);
                
                int charIdx = 0;
                while (charIdx < line.length() - 1){
                    sub.add(line.substring(charIdx, charIdx+2));
                    if(charIdx < line.length() - 2)
                        sub.add(line.substring(charIdx+1, charIdx+3));
                    charIdx = charIdx + 2;
                }
                              
                Lines.add(sub);
            }
            
            System.out.println("\nSorted Shingle Arrays:\n");
            
            for (SortedSet<String> sub: Lines){
                System.out.printf("%d : ", Lines.indexOf(sub));
                for(String s: sub){
                    System.out.printf("%s ", s);
                }
                System.out.println();
            }
            
            System.out.println("\nJaccard Similarity Matrix:\n");
            
            double maxScore = -1;
            int MaxA = -1, MaxB = -1;
            for (SortedSet<String> sub: Lines){
                for (SortedSet<String> sub2: Lines){
                    SortedSet<String> tmp = new TreeSet();

                    tmp.addAll(sub);
                    tmp.addAll(sub2);
                    
                    double score = (double)((sub.size() + sub2.size()) - tmp.size()) / tmp.size();
                    if (sub != sub2 && maxScore < score){
                        MaxA = Lines.indexOf(sub);
                        MaxB = Lines.indexOf(sub2);
                        maxScore = score;
                    }
                    System.out.printf("%1.4f ", score);
                }
                System.out.println();
            }
            
            System.out.printf("\nMost similar sentences: %d and %d with Jaccard value = %1.4f\n", MaxB, MaxA, maxScore);
        
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
}
