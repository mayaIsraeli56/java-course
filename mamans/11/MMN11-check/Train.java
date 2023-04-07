/*#Shadi:
 * grade 50/50
 */
/**
 * The Train class receives as input the speed and the travel time of two trains,
 * that start traveling at the same time and in the same direction.
 * The program calculates and prints the distance between the trains.
 *
 * @author Maya Israeli
 * @version 1
 */
import java.util.Scanner;
public class Train
{
    public static void main (String [] args)
    {
        final int MINUTES_IN_HOUR = 60;
        Scanner scan = new Scanner (System.in);

        System.out.println ("Please enter 4 integers");

        // Gets the speed and the travel time of train 1
        System.out.println ("Please enter the speed of train 1 (km/h):");
        int v1 = scan.nextInt();
        System.out.println ("Please enter the time of train 1 (min):");
        int t1 = scan.nextInt();

        // Gets the speed and the travel time of train 2
        System.out.println("Please enter the speed of train 2 (km/h):");
        int v2 = scan.nextInt();
        System.out.println("Please enter the time of train 2 (min):");
        int t2 = scan.nextInt();

        /*
         * Converts time from minutes to hours, calculates the distance (s=v*t) of each train,
         * Subtract to find the distance between the trains.
         */
        double trainsDistance =
            Math.abs(
                ((double) t1 / MINUTES_IN_HOUR) * v1 -
                ((double) t2 / MINUTES_IN_HOUR) * v2
            );

        System.out.println(
            "The distance between the trains is " + trainsDistance + " km."
        );

    } // end of method main
} //end of class Train 