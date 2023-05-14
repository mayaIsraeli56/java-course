public class Tar8 {

  public static int maxSumSnake(int[][] mat) {
    return maxSumSnake(mat, 0, 0, 0, 0);
  }

  public static int maxSumSnake(int[][] mat, int i, int j, int exI, int exJ) {
    int maxI = mat.length - 1;
    int maxJ = mat[0].length - 1;

    // reached end
    if (i == maxI && j == maxJ) {
      return mat[maxI][maxJ];
    }

    // dead end
    if (
      i < 0 ||
      i > maxI ||
      j < 0 ||
      j > maxJ ||
      mat[i][j] < 0 ||
      Math.abs(mat[i][j] - Math.abs(mat[exI][exJ])) > 1
    ) {
      return -1;
    }

    // mark the path
    mat[i][j] *= -1;

    int sum = -1;
    
    // go down
    int[][] mat2 = matCopy(mat);
    sum = Math.max(sum, maxSumSnake(mat2, i + 1, j, i, j));

    // go up
    mat2 = matCopy(mat);
    sum = Math.max(sum, maxSumSnake(mat2, i - 1, j, i, j));

    // go right
    mat2 = matCopy(mat);
    sum = Math.max(sum, maxSumSnake(mat2, i, j + 1, i, j));

    // go left
    mat2 = matCopy(mat);
    sum = Math.max(sum, maxSumSnake(mat2, i, j - 1, i, j));

    return (sum == -1) ? -1 : -mat[i][j] + sum;
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
