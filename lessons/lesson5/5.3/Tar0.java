import java.util.Scanner;

public class Tar0 {

    public static void Fibonacci(int n) {
        int n1 = 1;
        int n2 = 0;
        int n3;
        int i = 1;
        while (i < n) {
            n3 = n1 + n2;
            System.out.print(n3 + ", ");
            n2 = n1;
            n1 = n3;
            i++;
        }
        System.out.print(n1 + n2 + "\n ");
    }

    public static void Palindrom() {
        String s = "";
        int i;
        int sLength;

        while (s != "quit") {
            System.out.println("give me a string (type \"quit\" to stop)");
            Scanner scan = new Scanner(System.in);
            s = scan.next();

            for (i = 0, sLength = s.length(); i < sLength / 2; i++) {
                if (s.charAt(i) != s.charAt(sLength - 1 - i))
                    i = sLength;
            }

            System.out.println(i < s.length());
        }
    }

    public static void Table() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                System.out.print("(" + i + "," + j + ")");

            }
            System.out.print("\n");
        }
    }

    public static void PiramidX(int base) {
        if (base % 2 == 0)
            base++;

        for (int i = 0; i < base / 2 + 1; i++) {
            for (int j = 0; j < base; j++) {

                if (j >= base / 2 - i && j <= base / 2 + i)
                    System.out.print("*");
                else
                    System.out.print(" ");

            }
            System.out.println();
        }
    }

    public static void PiramidY(int base) {
        if (base % 2 == 0)
            base++;

        for (int i = 0; i < base / 2 + 1; i++) {
            for (int j = 0; j < base; j++) {

                if (j < base / 2 - i)
                    System.out.print(" ");
                else if (j <= base / 2 + i)
                    System.out.print("*");

            }
            System.out.println();
        }
    }

    public static void PrintDivisors() {
        int x = 0;

        System.out.println("enter numbers to print their divisors, -1 to stop.");
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();

        while (x != -1) {

            System.out.print("Divisors of " + x + " : ");

            if (x < 0)
                x = -x;

            for (int i = 1; i <= x; i++) {
                if (x % i == 0)
                    System.out.print(i + ", ");
            }

            System.out.println("\nenter numbers to print their divisors, -1 to stop.");
            x = scan.nextInt();
        }
        System.out.println("Goodbye!");
    }

    public static void printDiagonals(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1)
                    System.out.print(" 0 ");
                else
                    System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static int popDigit0(int n) {
        int[] a = new int[10];

        while (n > 0) {
            a[n % 10]++;
            n /= 10;
        }

        int index = 0;
        int max = 0;
        for (int j = 0; j < a.length; j++) {
            if (max < a[j]) {
                index = j;
                max = a[j];
            }
        }
        System.out.println(index);
        return index;
    }

    public static int popDigit1(int n) {

        int max = 0;
        int pop = n % 10;

        for (int n0 = n, digit0 = n0 % 10, count = 0; n0 > 0; n0 /= 10, digit0 = n0 % 10, count = 0) {
            for (int n1 = n, digit1 = n1 % 10; n1 > 0; n1 /= 10, digit1 = n1 % 10) {
                if (digit1 == digit0)
                    count++;
            }

            if (count > max) {
                pop = digit0;
                max = count;
            }

        }
        System.out.println(pop);
        return pop;
    }

    public static int popDigit(int n) {

        int max = 0;
        int pop = n % 10;

        for (int i = 0, count = 0; i < 10; i++, count = 0) {

            for (int n0 = n, digit = n0 % 10; n0 > 0; n0 /= 10, digit = n0 % 10) {
                if (digit == i)
                    count++;
            }

            if (count > max) {
                max = count;
                pop = i;
            }

        }
        System.out.println(pop);
        return pop;
    }

    public static void prime1000() {
        boolean prime = true;

        for (int i = 2; i <= 1000; i++, prime = true) {
            for (int j = 2; j <= Math.sqrt(i) && prime; j++) {

                if ((i % j) == 0)
                    prime = false;
            }
            System.out.println(i + ": " + prime);
        }

    }

    public static void dividers() {

        for (int i = 1, dividers = 0; i <= 1000; i++, dividers = 0) {
            for (int j = 1; j <= i; j++) {

                if (i % j == 0)
                    dividers++;
            }
            System.out.println(i + " has  " + dividers + " dividers");
        }

    }

    public static void what() {
        int i;
        for (i = 0; i < 6; i++)
            for (int j = 0; j < i; j++)
                System.out.println(j);
        System.out.println(i);
    }

    public static void toBinary(int n) {
        String n2 = "";
        do {
            n2 = (n % 2) + n2;
            n /= 2;
        } while (n > 0);
        System.out.println(n2);
    }

    public static void GCD(int n1, int n2) {
        int gcd = 0;
        for (int i = Math.min(n1, n2); gcd == 0; i--) {
            if (n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }
        System.out.println(gcd);
    }

    public static void Multiplication() {

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {

                if (i * j < 10)
                    System.out.print("0");
                System.out.print(j * i + "\t");
            }
            System.out.println();
        }

    }

    public static void FactorialSumBad(int n) {
        int sum = 0;
        for (int i = 1, factorial = 1; i <= n; i++, factorial = 1) {

            for (int j = 1; j <= i; j++) {
                factorial *= j;
            }
            sum += factorial;

        }
        System.out.println("1! + 2! + ... + " + n + "! = " + sum);
    }

    public static void FactorialSum(int n) {
        int sum = 0;
        for (int i = 1, factorial = 1; i <= n; i++) {
            factorial *= i;
            sum += factorial;
        }
        System.out.println("1! + 2! + ... + " + n + "! = " + sum);
    }

    public static void MultiplicationPalindromeBad(int n) {

        for (int n2 = (int) Math.pow(10, n - 1); n2 < Math.pow(10, n); n2++) {

            boolean isPolindrom = true;

            for (int i = 0, first, last; i <= (n - 1) / 2 && isPolindrom; i++) {
                first = (int) (n2 / Math.pow(10, i)) % 10;
                last = (int) (n2 / Math.pow(10, n - 1 - i)) % 10;
                isPolindrom = first == last;
            }

            if (isPolindrom)
                System.out.print(n2 + " ");
        }
    }

    public static void MultiplicationPalindrome(int n) {

        int tmp, newNum;
        for (int num = (int) Math.pow(10, n - 1); num < Math.pow(10, n); num++) {

            tmp = num;
            newNum = 0;

            while (tmp != 0) {
                newNum *= 10;
                newNum += tmp % 10;
                tmp /= 10;
            }

            if (newNum == num)
                System.out.println(num);
        }
    }

    public static void CountUpperLowwerCase(String s) {
        int countL = 0, countU = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                countL++;

            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                countU++;

        }

        System.out.println("Upper case count: " + countU + "\nLowwer case count: " + countL);
    }

    public static void isPartString() {
        char[] str1 = { 'H', 'e', 'l', 'l', 'o', 'w', ' ', 'w', 'o', 'r', 'l', 'd', 'w', 'o', 'r' };
        char[] str2 = { 'w', 'o' };

        boolean isPart;

        for (int i = 0; i < str1.length; i++) {
            isPart = true;

            for (int j = 0; j < str2.length; j++) {
                if (str1[i + j] != str2[j])
                    isPart = false;
            }

            if (isPart)
                System.out.println("contain, start with index " + i);
        }
    }
}
