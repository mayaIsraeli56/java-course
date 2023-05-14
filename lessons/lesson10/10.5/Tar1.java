public class Tar1 {

  public static int sum(int[][] a) {
    return sum(a, 0, 0);
  }

  private static int sum(int[][] a, int i, int j) {
    int curCell = a[i][j];

    if (j == a[i].length - 1) { // last cell
      if (i == a.length - 1) { // last row
        return curCell; // stop
      } else { // to next row
        i++;
        j = 0;
      }
    } else { // to next cell in the row
      j++;
    }
    return curCell + sum(a, i, j);
  }

  public static int sumBetter(int[][] a) {
    return sumBetter(a, 0, 0);
  }

  private static int sumBetter(int[][] a, int i, int j) {
    // stop condition - no elements
    if (i == a.length) {
      return 0;
    }

    int currCell = a[i][j];

    // find next element indexes
    if (j < a[i].length - 1) {
      // forward in the line
      j++;
    } else {
      // next new line
      i++;
      j = 0;
    }
    // sum = current + sum of the rest
    return currCell + sum(a, i, j);
  }

  public static int min(int[][] a) {
    return min(a, 0, 0);
  }

  private static int min(int[][] a, int i, int j) {
    // stop condition - last element
    if (i == a.length - 1 && j == a[i].length - 1) {
      return a[i][j];
    }

    int currCell = a[i][j];

    // find next element indexes
    if (j < a[i].length - 1) {
      // forward in the line
      j++;
    } else {
      // next new line
      i++;
      j = 0;
    }

    return Math.min(currCell, min(a, i, j));
  }

  public static int maxLineIdx(int[][] a) {
    return maxLineIdx(a, 0);
  }

  private static int maxLineIdx(int[][] a, int i) {
    if (i == a.length - 1) {
      return i;
    }

    int maxRowIdx = maxLineIdx(a, i + 1);
    int restMaxSum = sumRow(a[maxRowIdx], 0);
    int curSum = sumRow(a[i], 0);

    if (curSum < restMaxSum) {
      return maxRowIdx;
    }

    return i;
  }

  private static int sumRow(int[] row, int j) {
    if (j == row.length) {
      return 0;
    }

    return row[j] + sumRow(row, j + 1);
  }

 
}
