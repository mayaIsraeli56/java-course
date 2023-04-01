import java.util.Scanner;

public class Break {

    public static boolean guessPW(String pass) {
        String guess = "";
        int triesLeft = 3;
        Scanner scan = new Scanner(System.in);

        while (triesLeft > 0) {
            System.out.println("u have " + triesLeft + " tries left to guesses");
            guess = scan.next();
            if (guess.equals(pass)) {
                break;
            }
               
            triesLeft--;
        }
        scan.close();
        return triesLeft > 0 ? true : false;
    }
}
