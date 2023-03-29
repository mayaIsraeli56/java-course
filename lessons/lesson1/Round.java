import java.util.Scanner;

public class Round {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double round;
        double tmp = 0.5;
        System.out.println("Please input a real number");
        double n = scan.nextDouble();

        if(n<0)
            tmp*=-1;
         
        round = ( (int) (n *10 + tmp) )/ 10.0;        

        System.out.println("Rounded number " + round);
    }
}
