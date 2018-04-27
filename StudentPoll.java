/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 4/27/18
 *
 * Description: Create a file and store sequential data
 *****************************************************************/

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentPoll {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Formatter numbers = new Formatter();        
        int rating = 6;
        boolean continueEntry = true; // captures the exit program feedback    

        // create the file
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
        while(continueEntry == true) { 
            rating = dataCollection();  
            // Commits valid data to output using method format. 
            if(rating != 0) {
                System.out.println("---------------------------------");
                System.out.println("Your entry [ " + rating + " ] was saved.");
                System.out.println("---------------------------------");
                numbers.format("%d\n", rating); // commit data to text file.
                rating = 6;
            }
            else {
                numbers.close();
                System.out.println();
                System.out.println("Exiting Program.");
                System.out.println();
                continueEntry = false;
            }        
        }
    } // main()

    public static int dataCollection() {
        // Data integrity method (only 0-5 integers are valid)
        while(true) {
            int rate = 6;
            try {
                System.out.println("Rate this Java app on a scale of 1 through 5.");
                System.out.println("Type 0 then enter to exit.");
                System.out.print("Your rating: ");
                rate = input.nextInt();
                while(rate < 0 || rate > 5) {
                    notSaved();
                    System.out.print("Your rating: ");
                    rate = input.nextInt();
                }
                return rate;               
            }
            catch (InputMismatchException e) {
                notSaved();
                input.nextLine();
            }
        }
    } // dataCollection()

    public static void notSaved() {
        System.out.println("---------------------------------");
        System.out.println("ENTRY NOT SAVED: INVALID ENTRY");
        System.out.println("---------------------------------");
    } // notSaved()
        
} // class

