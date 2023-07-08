public class A2018 {

  public static int longestSlop(int[][] mat, int n) {
    return longestSlop(mat, n, 0, 0);
  }

  private static int longestSlop(int[][] mat, int n, int i, int j) {
    if (i >= mat.length) return 0;

    int max = longestSlop(mat, n, i, j, mat[i][j] + n);

    if (j < mat[0].length - 1) j++; else {
      i++;
      j = 0;
    }

    max = Math.max(max, longestSlop(mat, n, i, j));

    return max;
  }

  private static int longestSlop(int[][] mat, int n, int i, int j, int old) {
    int been = Integer.MIN_VALUE;

    if (
      i < 0 ||
      i >= mat.length ||
      j < 0 ||
      j >= mat[0].length ||
      mat[i][j] == been ||
      old - mat[i][j] != n
    ) return 0;

    int cur = mat[i][j];
    mat[i][j] = been;
    int max = 0;

    max = Math.max(longestSlop(mat, n, i + 1, j, cur), longestSlop(mat, n, i - 1, j, cur));
    max = Math.max(max, longestSlop(mat, n, i, j+1, cur));
    max = Math.max(max, longestSlop(mat, n, i, j-1, cur));

    mat[i][j] = cur;

    return max +1;
  }
}
