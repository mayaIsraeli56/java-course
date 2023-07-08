public class Knight2 {

  public static int maxSumKnight(int[][] mat) {
    if (mat == null) return -1;
    return maxSumKnight(mat, 0, 0);
  }

  private static int maxSumKnight(int[][] mat, int i, int j) {
    final int NOT_FOUND = -1;
    final int BEEN = -1;

    int len = mat.length;
    int width = mat[0].length;

    // check is step possible
    if (i < 0 || i >= len || j < 0 || j >= width || mat[i][j] <= BEEN) {
      return NOT_FOUND;
    }

    if (i == len - 1 && j == width - 1) {
      return mat[i][j];
    }

    // step is possible - mark this step
    mat[i][j] *= BEEN;

    // check all possible directions
    int[] paths = {
      NOT_FOUND,
      NOT_FOUND,
      NOT_FOUND,
      NOT_FOUND,
      NOT_FOUND,
      NOT_FOUND,
      NOT_FOUND,
      NOT_FOUND,
    };
    int maxPath = maxSumKnight(mat, i, j, 0, paths);

    // unmark this step
    mat[i][j] *= BEEN;

    return (maxPath == NOT_FOUND) ? NOT_FOUND : maxPath + mat[i][j];
  }

  private static int maxSumKnight(
    int[][] mat,
    int i,
    int j,
    int stap,
    int[] paths
  ) {
    final int DIFFERENCE = 1;

    if (stap == paths.length) {
      return findMax(paths, 0);
    }

    int[] verti = { -2, -2, -1, 1, 2, 2, 1 };
    int[] hori = { 1, -1, -2, -2, -1, 1, 2 };

    int nextI = i + verti[stap];
    int nextJ = j + hori[stap];

    if (!badIndex(mat.length, mat[0].length, i , j) && Math.abs(mat[nextI][nextJ] - mat[i][j]) <= DIFFERENCE) {
      paths[stap] = maxSumKnight(mat, nextI, nextJ);
    }

    return maxSumKnight(mat, i, j, stap + 1, paths);
  }

  private static int findMax(int[] a, int i) {
    if (i == a.length - 1) return a[i];
    return Math.max(a[i], findMax(a, i + 1));
  }

  private static boolean badIndex(int len, int width, int i, int j) {
    return i < 0 || i >= len || j < 0 || j >= width ;
  }
}
