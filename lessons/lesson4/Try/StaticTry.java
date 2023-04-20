package Try;
public class StaticTry {

    public static int max(int a, int b, int c) {
        return (Math.max(a, Math.max(b, c)));
    }

    public static void solve(double a, double b, double c) {
        double discriminant = Math.pow(b, 2) - 4 * a * c;

        //assume a != 0
        if (discriminant < 0 )
            System.out.println("There is no solution");
        else {
            double sqrt1 = (-b + Math.sqrt(discriminant)) / (2 * a);

            if (discriminant == 0 ) {
                System.out.println("only 1 sqrt : " + sqrt1);
                return;
            }
            
            double sqrt2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("sqrt1: "+ sqrt1 + "   sqrt2: "+ sqrt2);
        }            
    }
}