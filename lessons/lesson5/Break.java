import java.util.Scanner;

public class Break {
    public static ble main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = "aaaaa";
        String guess = "";
        char tries = 0;
        System.out.println("u have 3 tries to guesses");

        while (tries < 3) {
            if(guess != password) 
                return true;
        }
    }
}
