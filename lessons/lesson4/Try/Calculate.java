package Try;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter 3 numbers (double)");
        double n1 = scan.nextDouble();
        double n2 = scan.nextDouble();
        double n3 = scan.nextDouble();
        System.out.println("the average is: " + returnAverage(n1, n2, n3));

        System.out.println("Please enter 3 numbers (int- n hi lo)");
        int n = scan.nextInt();
        int hi = scan.nextInt();
        int lo = scan.nextInt();
        System.out.println("isInRange: " + isInRange(n, hi, lo));

        System.out.println("Please enter 2 strings");
        String s1 = scan.next();
        String s2 = scan.next();
        System.out.println("concat: " + concat(s1, s2));
        scan.close();
    }

    public static double returnAverage(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }

    public static boolean isInRange(int n, int hi, int lo) {
        return (n >= lo && n <= hi);
    }
    
    public static String concat(String s1, String s2) {
        return s1 + s2;
    }

}