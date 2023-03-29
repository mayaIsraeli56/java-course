
/**
 * The Train class prints calculation of difference between two trains.
 * 
 * @version 1
 */
import java.util.Scanner;

public class Train {
    /**
     * Gets the speed and the travel time of two trains from user,
     * Calculates and returns the distance between them.
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        final int MINUTES_IN_HOUR = 60;  
        double trainsDistance;

        System.out.println("Please enter 4 integers ");

        // Gets the information about the first train from user
        System.out.println("Please enter the speed of train 1 (km/h):");
        int v1 = scan.nextInt();
        System.out.println("Please enter the time of train 1 (min):");
        int t1 = scan.nextInt();

        // Gets the information about the second train from user
        System.out.println("Please enter the speed of train 2 (km/h):");
        int v2 = scan.nextInt();
        System.out.println("Please enter the time of train 2 (min):");
        int t2 = scan.nextInt();

        // Converts time from minutes to hours, calculates the distance
        /* trainsDistance = Math.abs(( (double)t1 / MINUTES_IN_HOUR) * v1 - ( (double)t2 / MINUTES_IN_HOUR) * v2); */
        trainsDistance = Math.abs( (double)(t1 * v1 - t2 *v2) /  MINUTES_IN_HOUR);

        System.out.println("The distance between the trains is " + trainsDistance + " km.");
    }// main
}// Train class
