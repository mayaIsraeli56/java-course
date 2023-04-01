public class Divisors {
    public static void divisors(int n) {
        int i = 2;
        System.out.println("Divisors of " + n + ": "); 

        while (i < n ) {
            if (n % i == 0 ) 
                System.out.print(i + " ");
                i++;
        }
        System.out.println("\n ");
    } 

    public static void divisorsForEach(int n) {
        int j, i = 1;

        while (i <= n) {
            System.out.println("\ndivisors of " + i + ": "); 
            j = 1;
            while (j <= i ) {
                if (i % j == 0 ) 
                    System.out.print(j + " " );
                    j++;
            }
            i++;
        }
        
    } 
}
