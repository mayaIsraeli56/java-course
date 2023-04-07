import java.util.Scanner;

public class Tar1 {
    public static void printTill() {
        int sum = 0, n = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Add a num to the sum: (0 to quite)");
            n = scan.nextInt();
            sum += n;
        } while (n != 0);

        System.out.println("sum: " + sum);
        scan.close();
    }

    public static void pow2(int n) {
        if (n <= 20) {// only for n <= 20
            for (int i = 0, num = 1; i <= n; i++, num *= 2) {
                System.out.println("2^" + i + " = " + num);
            }
        }
    }

    public static int mod(int n, int num) {
        int sing = 1;
        if (num < 0)
            sing = -1;

        for (System.out.print(num + " % " + n + " = "); num >= n || num < 1; num -= n * sing) {
            ;
        }
        System.out.println(num);
        return num;
    }

    public static int gcd(int p, int q) {
        p = Math.abs(p);
        q = Math.abs(q);

        int max = Math.min(p, q);
        for (; p % max != 0 || q % max != 0; max--) {
            ;
        }
        return max;
    }

    public static boolean isPrime(int num) {
        /*
         * int i;
         * for (i = 2; num % i != 0 ; i++) {
         * ;
         * }
         * 
         * return i == num ;
         */

        int i, sqrt = (int) Math.sqrt(num);
        for (i = 2; num % i != 0 && i <= sqrt; i++) {
            ;
        }

        return i == sqrt + 1;
    }

    public static void isIncreasing() {
        Scanner scan = new Scanner(System.in);
        int i = 1;

        for ( int digit = 0, lastDigit = -1 ; i <= 10 && digit > lastDigit ; i++) {
            lastDigit = digit;
            System.out.println("Please enter a num (" + i + "/10)" );
            digit = scan.nextInt();
            
        }

        System.out.println(i == 11);
    }
}
