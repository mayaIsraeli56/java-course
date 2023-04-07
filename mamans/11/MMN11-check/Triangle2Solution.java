import java.util.Scanner;
/**
 * Write a description of class Triangle2Solution here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Triangle2Solution
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("This program...");
        System.out.println ("Please enter the three lengths of the triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        double perimeter , area, s;
        // REMARK: if sides are negative of if 2 sides are smaller than the third side
        if ((a<=0)||(b<=0)||(c<=0) || (a+b <= c) || (a+c <= b)|| (b+c <= a))
            System.out.println("The numbers: "+a+", "+b+" and "+c+" cannot represent a triangle");
        else
        {
            if(a==b && a==c) // if 3 sides are equal
                System.out.println("The numbers: "+a+", "+b+" and "+c+" represent an equilateral triangle");
            else if(a==b || a==c || b==c) // if 3 sides are equal
                System.out.println("The numbers: "+a+", "+b+" and "+c+" represent an isosceles triangle");
                else if(Math.pow(a,2)+Math.pow(b,2)==Math.pow(c,2) || 
                        Math.pow(a,2)+Math.pow(c,2)==Math.pow(b,2) || 
                        Math.pow(b,2)+Math.pow(c,2)==Math.pow(a,2)) 
                        System.out.println("The numbers: "+a+", "+b+" and "+c+" represent a right-angle triangle");
                     else
                        System.out.println("The numbers: "+a+", "+b+" and "+c+" represent a common triangle");
        }            
    } // end of method main} 
}//end of class Triangle