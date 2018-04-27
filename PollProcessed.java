/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 4/27/18
 *
 * Description: Process Poll Data send to output.txt
 *****************************************************************/

import java.util.Scanner;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;

public class PollProcessed {
    
    // used to get element count of file then dumped.
    private static Scanner input0;
    // used to capture data for analysis.
    private static Scanner input;

    public static void main(String[] args) {
        int count = 0;
        int[] frequency = new int[6];
        Formatter analysis = new Formatter();   

        try {
            input0 = new Scanner(new File("numbers.txt"));
            analysis = new Formatter("output.txt");
            
            // count records of raw data
            int recordCount = 1;
            while(input0.hasNext()) {
                input0.nextInt();
                recordCount++;
            }

            input = new Scanner(new File("numbers.txt"));

            int[] data = new int[recordCount];

            while(input.hasNext()) {
                data[count] = input.nextInt();
                count++;
            }      
            // analysis      
            for(int answer = 0; answer < data.length; answer++) {
                ++frequency[data[answer]];
            }

            // output
            System.out.printf("%s%10s\n", "Rating", "Frequency");
            analysis.format("%s%10s\n", "Rating", "Frequency");

            for(int rating = 1; rating < frequency.length; rating++) {
                System.out.printf("%s%10s\n", rating, frequency[rating]);
                analysis.format("%s%10s\n", rating, frequency[rating]);
            }
            System.out.println();
            System.out.println("File Created: output.txt");
            System.out.println();

        }
        catch(NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        }
        catch(IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException) {
            System.err.println("File cannot be found.");
            System.exit(1);
        }
        catch(ArrayIndexOutOfBoundsException outOfBounds) {
            System.err.println("File too large.");
            System.exit(1);
        }
        finally {
            if(input != null) {
                input0.close();
                input.close();
                analysis.close();
            }
        }
    }
}
