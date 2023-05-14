public class Tar7 {

  public static boolean eightQueens(int[][] a) {
    int[] cell = { 0, 0 };
    int[][] queensPlaces = new int[2][8];
    allMinus1(queensPlaces);
    return eightQueens(a, 0, cell, queensPlaces);
  }

  private static boolean eightQueens(
    int[][] a,
    int nQueen,
    int[] cell,
    int[][] queensPlaces
  ) {
    if (nQueen == 8) { // all 8 queens on board
      return true;
    }

    cell = findNextCell(a, cell[0], cell[1]); // find next avilable cell - based on the last checked cell

    if (cell[0] == -1) { // no cell avilable
      return false;
    }

    placeAndRemoveQ(a, nQueen, cell, queensPlaces);

    if (eightQueens(a, nQueen + 1, cell, queensPlaces)) {
      return true;
    }

    placeAndRemoveQ(a, nQueen, cell, queensPlaces);
    return eightQueens(a, nQueen, cell, queensPlaces);
  }

  private static int[] findNextCell(int[][] a, int i, int j) {
    int[] cell = { -1, -1 };

    if (i == a.length) { // all cells checkd - non is available
      return cell;
    }

    if (a[i][j] == 0) { // avilable cell
      cell[0] = i;
      cell[1] = j;
      return cell;
    }

    if (j == a[i].length - 1) { // find the indexes of the next cell
      i++;
      j = 0;
    } else {
      j++;
    }
    return findNextCell(a, i, j);
  }

  private static void placeAndRemoveQ(
    int[][] a,
    int nQueen,
    int[] cell,
    int[][] queensPlaces
  ) {
    if (a[cell[0]][cell[1]] == 2) {
      // queen should be removed
      a[cell[0]][cell[1]] = 0;
      // remove from list
      queensPlaces[0][nQueen] = -1;
      queensPlaces[1][nQueen] = -1;
    } else {
      // queen should be placed
      a[cell[0]][cell[1]] = 2;
      queensPlaces[0][nQueen] = cell[0];
      queensPlaces[1][nQueen] = cell[1];
    }

    // clear all unavilable cells (1)
    clearBlockedCells(a, 0, 0);

    // block unavilable cells
    block(a, queensPlaces);
  }

  private static void clearBlockedCells(int[][] a, int i, int j) {
    if (i == a.length) {
      return;
    }

    if (a[i][j] == 1) {
      a[i][j] = 0;
    }

    if (j == a[i].length - 1) { // find the indexes of the next cell
      i++;
      j = 0;
    } else {
      j++;
    }

    clearBlockedCells(a, i, j);
  }

  private static void block(int[][] a, int[][] queensPlaces) {
    int nQueen = 0;
    while (nQueen < queensPlaces[0].length && queensPlaces[0][nQueen] != -1) {

        int rowIndex = queensPlaces[0][nQueen];
        int colIndex = queensPlaces[1][nQueen];
        int numRows = a.length;
        int numCols = a[0].length;

      // change row
      int row = rowIndex;
      int col;
      for (col = 0; col < numCols; col++) {
        a[row][col] = 1;
      }

      // change column
      col = colIndex;
      for (row = 0; row < numRows; row++) {
        a[row][col] = 1;
      }

   
      // Change the value of cells on the primary diagonal
      for (int i = 0; i < numRows; i++) {
        int j = colIndex + (i - rowIndex);
        if (j >= 0 && j < numCols) {
          a[i][j] = 1; // Change the value to your desired value
        }
      }

      // Change the value of cells on the secondary diagonal
      for (int i = 0; i < numRows; i++) {
        int j = colIndex - (i - rowIndex);
        if (j >= 0 && j < numCols) {
          a[i][j] = 1; // Change the value to your desired value
        }
      }
      nQueen++;
    }
  }

  private static void allMinus1(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        a[i][j] = -1;
      }
    }
  }
}
