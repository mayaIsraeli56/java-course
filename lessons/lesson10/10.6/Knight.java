public class Knight {

  public static boolean CoverBoard(int[][] board, int x, int y) {
    if (CoverBoard(board, x, y, 0)) {
      return true;
    }

    System.out.println("Failed to cover board");
    return false;
  }

  public static boolean CoverBoard(int[][] board, int x, int y, int covered) {
    final int AVIL = 0;
    int len = board.length;

    // check is step possible
    if (x < 0 || x >= len || y < 0 || y >= len || board[x][y] != AVIL) {
      return false;
    }

    // step is possible - mark this step
    board[x][y] = ++covered;

    if (covered == len * len) { // covered ran from 1 to len*len
      System.out.println(ToString.arr2String(board));
      board[x][y] = AVIL; // unmark last step
      return true;
    }

    // check all possible directions
    boolean dir1 = CoverBoard(board, x + 2, y + 1, covered);
    boolean dir2 = CoverBoard(board, x + 1, y + 2, covered);
    boolean dir3 = CoverBoard(board, x - 1, y + 2, covered);
    boolean dir4 = CoverBoard(board, x - 2, y + 1, covered);
    boolean dir5 = CoverBoard(board, x - 2, y - 1, covered);
    boolean dir6 = CoverBoard(board, x - 1, y - 2, covered);
    boolean dir7 = CoverBoard(board, x + 1, y - 2, covered);
    boolean dir8 = CoverBoard(board, x + 2, y - 1, covered);

    // unmark this step
    board[x][y] = AVIL;

    // Is there at least one path that leads from the current point to the end
    return (dir1 || dir2 || dir3 || dir4 || dir5 || dir6 || dir7 || dir8);
  }
}
