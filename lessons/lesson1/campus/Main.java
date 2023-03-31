import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        System.out.println("Give me a num");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int factorial = 1;

        while(n > 0) {
            factorial = factorial * n;
            n--;
        }

        System.out.println( "factorial " + factorial);

    }
}

