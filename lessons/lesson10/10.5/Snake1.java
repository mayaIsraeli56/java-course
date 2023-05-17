public class Snake1 {

  public static int maxSumSnake(int[][] mat) {
    return maxSumSnake(mat, 0, 0, 0, 0);
  }

  public static int maxSumSnake(int[][] mat, int i, int j, int exI, int exJ) {
    int maxI = mat.length - 1;
    int maxJ = mat[0].length - 1;

    // dead end
    if (i < 0 ||
        i > maxI ||
        j < 0 ||
        j > maxJ ||
        mat[i][j] < 0 ||
        Math.abs(mat[i][j] - Math.abs(mat[exI][exJ])) > 1) {
      return -1;
    }

    // reached end
    if (i == maxI && j == maxJ) {
       return mat[i][j];
     }

    // mark the path
    mat[i][j] *= -1;

    int up = -1, down = -1, left = -1, right = -1;

    // go down
    down = maxSumSnake(mat, i + 1, j, i, j);

    // go up;
    up = maxSumSnake(mat, i - 1, j, i, j);

    // go right
    right = maxSumSnake(mat, i, j + 1, i, j);

    // go left
    left = maxSumSnake(mat, i, j - 1, i, j);

    // unmark the path
    mat[i][j] *= -1;

    // couldn't find a path
    if (up == -1 && down == -1 && left == -1 && right == -1)
      return -1;

    // return the max path
    int max = Math.max(Math.max(up, down), Math.max(left, right));
    return max + mat[i][j];
  }

  public static int[][] matCopy(int[][] m1) {
    int[][] m2 = new int[m1.length][m1[0].length];
    return matCopy(m1, m2, 0, 0);
  }

  public static int[][] matCopy(int[][] m1, int[][] m2, int i, int j) {
    if (i == m1.length) {
      return m2;
    }

    m2[i][j] = m1[i][j];

    if (j == m1[i].length - 1) { // find the indexes of the next cell
      i++;
      j = 0;
    } else {
      j++;
    }
    return matCopy(m1, m2, i, j);
  }
}
