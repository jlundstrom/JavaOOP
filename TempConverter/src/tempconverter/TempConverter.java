/*
 * University of Central Florida
 * COP3303 - Fall 2015
 * Author:  Jonathan Lundstrom
 */
package tempconverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jonathan
 */
public class TempConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            Scanner input = new Scanner(new FileInputStream(file));

            System.out.println("Temperature Converter by Jonathan Lundstrom");
            System.out.printf("%-7s %-5s %s%n", "Input", "Type", "Conversion");
            System.out.println("------------------------");
            while (input.hasNext()) {
                double t = input.nextDouble();
                String s = input.nextLine();
                s = s.trim();
                System.out.printf("%6.2f  %-7s", t, s);
                if (s.equals("C")) {
                    System.out.printf("%6.2f F%n", ((9 * t) / 5) + 32);
                } else {
                    System.out.printf("%6.2f C%n", ((t - 32) * 5) / 9);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

}
