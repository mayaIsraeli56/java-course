public class B202192 {

  public static int printExpr(int[] a, int n) {
    if (a == null || a.length <= 0) return -1;

    return printExpr(a, n, 0, "");
  }

  private static int printExpr(int[] a, int n, int i, String s) {
    if (n == 0) {
      System.out.println(s);
      return 1;
    }

    if (i == a.length) return 0;

    int cur = a[i++];

    return (
      printExpr(a, n - cur, i, s + "+" + cur + " ") +
      printExpr(a, n + cur, i, s + "-" + cur + " ") +
      printExpr(a, n, i, s)
    );
  }

  public static int longestSeq(int[] a, int k) {
    if (a == null || k < 0) return -1;

    int count = 0, i = 0, j = 0, max = 0;

    while (i < a.length) {
      while (count <= k && i < a.length) {
        if (a[i] == 0) count++;
        i++;
      }

      max = Math.max(max, i - j - 1);

      if (i < a.length) {
        if (a[j] == 0) j++; else {
          do {
            j++;
          } while (a[j] != 0);
          j++;
        }
        count--;
      }
    }
    return max;
  }
}
