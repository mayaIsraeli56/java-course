public class King {

  public static int minPath(char[][] board, int x, int y, int count) {
    final int TAKEN = 'X';
    final int KING = 'K';
    int len = board.length;

    if (x < 0 || x >= len || y < 0 || y >= len || board[x][y] == TAKEN) {
      return -1;
    }

    if (board[x][y] == KING) {
      return count;
    }

    char old = board[x][y];
    board[x][y] = TAKEN;

    int[] dir = {
      minPath(board, x + 2, y + 1, count + 1),
      minPath(board, x + 1, y + 2, count + 1),
      minPath(board, x - 1, y + 2, count + 1),
      minPath(board, x - 2, y + 1, count + 1),
      minPath(board, x - 2, y - 1, count + 1),
      minPath(board, x - 1, y - 2, count + 1),
      minPath(board, x + 1, y - 2, count + 1),
      minPath(board, x + 2, y - 1, count + 1),
    };

    board[x][y] = old;

    return minPath(dir);
  }

  private static int minPath(int[] dir) {
    int min = dir[0];

    for(int i=1; i< dir.length ; i++) {
        if(dir[i] != -1 && (min == -1 || dir[i] < min)) {
            min = dir[i];
        }
    }

    return min;
  }
}
