/*#Shadi:
 * grade 50/50
 */
/**
 * The Triangle class gets three integers as an input, 
 * checks if the given numbers can represent the length of sides of a triangle.
 * If so, check in the following order whether the triangle is
 * equilateral, isosceles, right angled or a regular triangle.
 * The program prints only one message,
 * the first one that was checked and returned a positive answer.
 * 
 * @author Maya Israeli
 * @version 1
 */
import java.util.Scanner;
public class Triangle 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        //the three sides of a triangle
        int side1, side2, side3;

        // Gets the length of the 3 sides from the user
        System.out.println("Please enter 3 integers ");
        side1 = scan.nextInt();
        side2 = scan.nextInt();
        side3 = scan.nextInt();

        // Saves the beginning of the output sentence
        String sidesText = "The numbers: " + side1 + ", " + side2 + " and " + side3;

        // Checks if the lengths can make a triangle
        if ( side1 + side2 > side3 &&
             side2 + side3 > side1 &&
             side3 + side1 > side2 &&
             side1>0 &&
             side2>0 &&
             side3>0 )
        { // they can make a triangle, the program determines its type

            // is equilateral
            if (side1 == side2 && side2 == side3) 
                System.out.println( sidesText + " represent an equilateral triangle");
            
            // is isosceles
            else if (side1 == side2 || side2 == side3 || side1 == side3) 
                System.out.println( sidesText + " represent an isosceles triangle");
            
            // is right-angle
            else if ((Math.pow(side1, 2) + Math.pow(side2, 2) == Math.pow(side3, 2)) || 
                     (Math.pow(side2, 2) + Math.pow(side3, 2) == Math.pow(side1, 2)) || 
                     (Math.pow(side3, 2) + Math.pow(side1, 2) == Math.pow(side2, 2))) 
                System.out.println( sidesText +  " represent a right-angle triangle");
            
            // otherwise is common
            else 
                System.out.println( sidesText +  " represent a common triangle");

        } else // they can't make a triangle
            System.out.println( sidesText + " cannot represent a triangle"); 
            
    } // end of method main
} //end of class Triangle 
