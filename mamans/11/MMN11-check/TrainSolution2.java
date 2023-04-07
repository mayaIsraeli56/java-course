import java.util.Scanner;
public class TrainSolution2
{
    static final double MAX = 100;
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println ("Please enter 4 integers "); 
        System.out.println ("Please enter the speed of train 1:");
        int v1 = scan.nextInt();
        System.out.println ("Please enter the time of train 1:");
        int t1 = scan.nextInt();
        System.out.println ("Please enter the speed of train 2:");
        int v2 = scan.nextInt();
        System.out.println ("Please enter the time of train 2:");
        int t2 = scan.nextInt();
        double result = Math.abs(v1*t1/60.0 - v2*t2/60.0);
        result = Math.round (result * MAX) / MAX;
        System.out.println("The distance between the trains is " + result + " km.");
        scan.close();
    } // end of method main
}
