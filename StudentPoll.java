/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 4/26/18
 *
 * Description: Create a file and store sequential data
 *****************************************************************/

import java.io.FileNotFoundException;
import java.lang.SecurityException; // Do I need to import lang?
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentPoll {


    public static void main(String[] args) {
        Formatter numbers = new Formatter();
        Scanner input = new Scanner(System.in);
        
        

        try {
            numbers = new Formatter("numbers.txt");
        }
        catch(SecurityException e) {
            System.err.println("You do not have write access to this file.");
            System.exit(1);
        }
        catch(FileNotFoundException e) {
            System.err.println("Error opening or creating file.");
            System.exit(1);
        }

        // User Input (Data Collection)
        boolean dataEntry = false;
        while(dataEntry == false) {
            int rating = 0;
            try {
                System.out.print("How would you rate this Java Application: ");
                rating = input.nextInt();                
            }
            catch (InputMismatchException e) {
                System.out.print("Invalid entry, try again: ");
                rating = input.nextInt();
            }
            
            if(rating > 0 && rating < 6) {
                numbers.format("%d\n", rating);
                rating = 0;
            }
            else {
                numbers.close();
                System.out.println("Exiting Program.");
                dataEntry = true;                
            }
        }


    } // main()     
        
} // class

