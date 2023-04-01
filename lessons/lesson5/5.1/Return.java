import java.util.Scanner;

public class Return {    
    
    public static boolean guessPW(String pass) {
        String guess = "";
        int triesLeft = 3;
        Scanner scan = new Scanner(System.in);

        while (triesLeft > 0) {
            System.out.println("u have " + triesLeft + " tries left to guesses");
            guess = scan.next();
            if (guess.equals(pass)) {
                scan.close();
                return true;
            }
               
            triesLeft--;
        }
        scan.close();
        return false;
    }
}
