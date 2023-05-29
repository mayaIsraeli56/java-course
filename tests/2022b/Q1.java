public class Q1 {

  public static int calc(int num, int result, int maxOp) {
    return calc(num, result, maxOp, num, num + "");
  }

  private static int calc(int num, int result, int maxOp, int sum, String str) {
    if (sum == result) {
      System.out.println(str);
      return 1;
    }

    if (maxOp == 0) {
      return 0;
    }

    maxOp--;

    return (
      calc(num, result, maxOp, sum + num, str + "+" + num) +
      calc(num, result, maxOp, sum - num, str + "-" + num) +
      calc(num, result, maxOp, sum * num, str + "*" + num) +
      calc(num, result, maxOp, sum / num, str + "/" + num)
    );
  }
}
