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
}
