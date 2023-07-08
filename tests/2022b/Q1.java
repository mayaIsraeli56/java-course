public class Q1 {

  public static int meetingPoint(int[] a, int[] b) {
    final int NOT_FOUND = -1;

    if (a == null || b == null || a.length == 0 || b.length == 0) {
      return NOT_FOUND;
    }

    int lo = 0;
    int hi = Math.min(a.length, b.length) - 1;
    int mid, idx = NOT_FOUND;

    while (lo <= hi) {
      mid = (lo + hi) / 2;

      if (a[mid] <= b[mid]) {
        hi = mid - 1;
        if (a[mid] == b[mid] && (mid < idx || idx == NOT_FOUND)) {
          idx = mid;
        }
      } else {
        lo = mid + 1;
      }
    }

    return idx;
  }

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

  public static int findMax(int[][] mat) {
    if (mat == null || mat.length == 0 || mat[0].length == 0 || mat[0][0] == -1) return -1;

    return findMax(mat, 0, 0);
  }

  private static int findMax(int[][] mat, int i, int j) {
    final int END = -1;
    final int STOP = 0;
    final int MARKER = 2;

    if (
      i < 0 ||
      j < 0 ||
      i >= mat.length ||
      j >= mat[0].length ||
      mat[i][j] <= END
    ) {
      return STOP;
    }

    mat[i][j] -= MARKER;

    int side = (i % 2 == 0) ? findMax(mat, i, j + 1) : findMax(mat, i, j - 1);
    int down = findMax(mat, i + 1, j);

    mat[i][j] += MARKER;

    return Math.max(side, down) + mat[i][j];
  }

  public static int strictleIncreasing( int[] a) {
    int sum = 0, start = 0 , last = 1;

    while (last < a.length) {
      if(a[last-1] < a[last]) sum += last - start;
      else start = last;
      last++;
    }

    return sum;
  }
}
