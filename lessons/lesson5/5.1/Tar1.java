public class Tar1 {
    public static void sumOfEvenDigits(int n) {
        System.out.print("sum of the even digits of " + n + ": ");
        int digit, sum = 0;
        while (n != 0) {
            digit = n % 10;
            if (digit % 2 == 0)
                sum += digit;
            n /= 10;
        }
        System.out.print(sum + "\n ");
    }

    public static int mod(int n, int num) {
        while (num >= n) {
            num -= n;
        }
        return num;
    }

    public static int gcd(int p, int q) {
        int d = 1; // divisor
        int i = Math.min(p, q);

        if (p < 0)
            p = -p;
        if (q < 0)
            q = -q;

        while (i > 1) {
            if (p % i == 0 && q % i == 0) {
                d = i;
                break;
            }
            i--;
        }

        return d;
    }

    public static void infiniteLoop() {
        double n = 1.0;
        while (n != 0 ) { // infinite loop
            System.out.print(n);
            n-=0.1;
        }
    }

    public static boolean isEqualsDistance(int num) {
        
        int digit1 = num % 10;
        int digit2 = ( num / 10 ) % 10;
        int dis = Math.abs(digit1 - digit2);
        num /= 100;
        boolean isEquals = true;
        
        while (num > 0 && Math.abs(digit1 - digit2) == dis ) {
            digit1 = digit2;
            digit2 = num % 10;
            
            if (Math.abs(digit1 - digit2) != dis )
            isEquals = false;
            
            num /= 10;
        }
        
        return isEquals;
    }
}