
package tortoiseharesimulator;
//Simulation of classic race of the Tortoise and the Hare
import java.util.Random;

public class TortoiseHareSimulator {

      private static final Random randomNumbers = new Random();
    
    public static void main(String[] args)
    {
        int tortoise = 1; //set tortoise at starting gate
        int hare = 1; // set hare at starting gate
        int[] track = new int[71];
        
        System.out.println("BANG !!!!!\nAND THEY'RE OFF !!!!!");
        
        for (int counter = 0; counter <= 70; counter++)
        {
            track[counter] = counter;
        }
        
        while (tortoise < track[70] && hare < track[70] )
        {
            tortoise = moveTortoise(tortoise);
            hare = moveHare(hare);
            displayTrack(track, tortoise, hare);
        }
        
        if ( tortoise >= track[70] && hare < track[70])
            System.out.println("TORTOISE WINS!!! YAY!!!");
        else if (hare >= track[70] && tortoise < track[70])
            System.out.println("Hare wins. Yuch.");
        else if (tortoise >= track[70] & hare >= track[70])
            System.out.println("It's a tie.");
        
    }
    
    // move tortoise based on random number percentages
    public static int moveTortoise(int t)
    {
        int i = 1 + randomNumbers.nextInt(10);
        
        if (i >= 1 & i <= 5)
            t += 3;
        else if (i >= 6 & i <= 7)
            t -= 6;
        else if (i >= 8 & i <= 10)
            t += 1;
        
        if (t < 0)
            t = 1;
        
        return t;
        
    }
    
    // move hare based on random number percentages
    public static int moveHare(int h)
    {
        int i = 1 + randomNumbers.nextInt(10);
        
        if (i >= 1 & i <= 2)
            h += 0;
        else if (i >= 3 & i <= 4)
            h += 9;
        else if (i == 5)
            h -= 12;
        else if (i >= 6 & i <= 8)
            h += 1;
        else if (i >= 9 & i <= 10)
            h -= 2;
        
        if (h < 0)
            h = 1;
        
        return h;
    }
    
    // display track indicating positions of the tortoise and hare
    public static void displayTrack(int[] array, int t, int h)
    {
        for (int counter = 1; counter < array.length; counter++)
        {
            if (t == array[counter] && h == array[counter] )
                System.out.print("OUCH!!!");
            else if (t == array[counter])
                System.out.print("T");
            else if (h == array[counter])
                System.out.print("H");
            else 
                System.out.print(" ");
        }
        System.out.println();
    }

}
