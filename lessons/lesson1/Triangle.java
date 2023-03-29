/**
 * Checks if given numbers can represent the length of the sides of a triangle,
 * if so determine its type.
 * 
 * @version 1
 */
import java.util.Scanner;

public class Triangle {
    /**
     * Gets 3 numbers from user,
     * checks if they can represent the length of the sides of a triangle,
     * in case of illegal time - prints appropriate notice
     * otherwise - calculates their difference
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Gets 3 integers from user
        System.out.println("Please enter 3 integers ");
        int side1 = scan.nextInt();
        int side2 = scan.nextInt();
        int side3 = scan.nextInt();

      // Checks if they can make a triangle
        if ((side1 + side2 < side3) || (side2 + side3 < side1) || (side3 + side1 < side2)) 
            System.out.println( side1 + ", " + side2 + " and " + side3 + " cannot represent a triangle ");
       

    }// main
}// Clock class
