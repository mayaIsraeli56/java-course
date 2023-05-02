public class Tar1 {

  public static void AllXDigitsNums(int numOfdigits) { // numOfdigits-num of digits
    int values = 3; // 0,1
    int prints = (int) Math.pow(values, numOfdigits);

    int[] digits = new int[numOfdigits];

    for (int i = 1; i <= prints; i++) {
      for (int j = 0; j < numOfdigits; j++) {
        System.out.print(digits[j]);
      }
      System.out.print("\t");

      for (int j = 0; j < numOfdigits; j++) {
        if (i % (prints / Math.pow(values, j + 1)) == 0) {
          digits[j] += 1;
          digits[j] %= values;
        }
      }
    }
  }

  public static void printStars(int n) {
    if (n > 0) {
      System.out.print("*");
      printStars(n - 1);
    }
    System.out.println();
  }

  public static int Factorial(int n) {
    if (n > 1) {
      return n * Factorial(n - 1);
    }
    return 1;
  }

  public static int a_n(int n) {

    int a1 = 2;

    if (n == 1) {
      return a1;
    }

    int d = 3;
    return a_n(n - 1) + d;
  }

  public static int fib(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }

    int a_n1 = fib(n - 1);
    int a_n2 = fib(n - 2);

    return a_n1 + a_n2;
  }

  public static int sumElements(int n) {
    int odd = 3;
    int even = 5;

    if (n == 0) {
      return 0;
    }

    int S_n = sumElements(n-1); 
    S_n += (n % 2 == 0) ? even : odd ;

    return S_n;
  }

  public static int sumDigits(int n) {
  
    if (n == 0) {
      return 0;
    }

    int s = n% 10;
    s+= sumDigits(n/10); 

    return s;
  }
}
