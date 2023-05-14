public class Tar4 {
    /*  public static void fillHadamard(int mat[][]) {
    mat[0][0] = 1;
    fillHadamard(mat, 1);
  }

  private static void fillHadamard(int mat[][], int len) {
    if (len == mat.length) {
      return;
    }

    fillHadamard(mat, 0, 0, len); // make it bigger
    fillHadamard(mat, 2 * len); // rec
  }

  private static void fillHadamard(int mat[][], int i, int j, int len) {
    if (i == len) {
      return;
    }

    mat[i][j + len] = mat[i][j]; // copy 1
    mat[i + len][j] = mat[i][j]; // copy 2
    mat[i + len][j + len] = -mat[i][j]; // copy 3

    if (j < len -1) {
      j++;
    } else {
      i++;
      j = 0;
    }

    fillHadamard(mat, i, j, len);
  } */

  public static void fillHadamard(int mat[][]) {
    fillHadamard(mat, 0, 0, mat.length, 1);
  }

  private static void fillHadamard(
    int[][] mat,
    int top,
    int left,
    int size,
    int sign
  ) {
    if (size == 1) {
      mat[top][left] = sign;
    } else {
      fillHadamard(mat, top, left, size / 2, sign);
      fillHadamard(mat, top + size / 2, left, size / 2, sign);
      fillHadamard(mat, top, left + size / 2, size / 2, sign);
      fillHadamard(mat, top + size / 2, left + size / 2, size / 2, (-1) * sign);
    }
  }

}
