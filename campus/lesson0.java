

 import java.util.Scanner;
 
public class Factorial {

    /**
     * calculate factorial for input
     * @param n -  a positive integer
     * @return factorial of n
     */
     
     public void main() {
         
        System.out.println("give me a num");
        Scanner scanner = new Scanner(System.in);
        
         while (scanner.hasNext()) {
  

                System.out.println("N"+ scanner.nextInt());
            }
            
        int a = scanner.nextInt();
          int b = solve(a);
          System.out.println(b);
   }
   
   
    public int solve(int n) {
        //implemt your code here
        int factorial = 1;
        
        while(n > 0) {
            factorial = factorial * n;
            n--;
        }

        return factorial;
    }
}


