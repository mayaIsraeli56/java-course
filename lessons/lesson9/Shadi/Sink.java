public class Sink {

  public static int isSink(int[][] mat) {
    int i = 0, j = 1;

    for (int next = 2; next <= mat.length; next++) {
      if (mat[i][j] == 1) {
        i = next;
      } else { // mat[i][j] == 0
        j = next;
      }
    }

    i = (j < i) ? j : i;

    for (j = 0; j < mat.length; j++) {
      if (mat[i][j] != 0 || (mat[j][i] != 1 && j != i)) {
        return -1;
      }
    }

    return i;
  }

}
