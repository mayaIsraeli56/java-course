public class Calc {

  public static int calc(int num, int result, int maxOp) {
    return calc(num, result, maxOp, num, num + "");
  }

  private static int calc(int num, int result, int maxOp, int sum, String exp) {
    if (sum == result) {
      System.out.println(exp);
      return 1;
    }

    if (maxOp == 0) {
      return -1;
    }

    int opts = 0, tmp;
    maxOp--;

    tmp = calc(num, result, maxOp, sum + num, exp+ "+" + num);
    opts = (tmp != -1)? opts + tmp: opts;

    tmp = calc(num, result, maxOp, sum - num, exp+ "-" + num);
    opts = (tmp != -1)? opts + tmp: opts;

    tmp = calc(num, result, maxOp, sum * num, exp+ "*" + num);
    opts = (tmp != -1)? opts + tmp: opts;

    tmp = calc(num, result, maxOp, sum / num, exp+ "/" + num);
    opts = (tmp != -1)? opts + tmp: opts;

    return opts;
  }
}
