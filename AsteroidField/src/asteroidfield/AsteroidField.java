/*
 * University of Central Florida
 * COP3303 - Fall 2015
 * Author:  Jonathan Lundstrom
 */
package asteroidfield;
import blobzx.*;
import java.util.Random;

public class AsteroidField implements BlobGUI {

    public static void main(String[] args) {
        new AsteroidField();
        
    }
    
    private final SandBox sandBox;
    
    public AsteroidField() {
        // Build sandbox
        sandBox = new SandBox();
        sandBox.setSandBoxMode(SandBoxMode.FLOW);
        sandBox.setFrameRate(15);
        sandBox.init(this);
    }

    @Override
    public void generate() {
        // Randomly generate 20 astroids with random x/y deltas and rot speeds
        Random ran = new Random();
        for(int i = 0; i < 20; i++) {
            int x = (ran.nextInt(3) + 1) * (ran.nextBoolean() ? -1: 1);
            int y = (ran.nextInt(3) + 1) * (ran.nextBoolean() ? -1: 1);
            double r = ran.nextBoolean() ? -.1: .1;
            
            sandBox.addBlob(new Astroid(x,y,r));
        }
    }
    
}
