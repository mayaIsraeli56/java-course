public class Knight {
    public static boolean CoverBoard(int[][] board, int x, int y) {
        boolean isSuc = CoverBoard(board, x, y, 0, "");

        if(!isSuc) 
            System.out.println("Failed to cover board");

        return isSuc;
    }

    public static boolean CoverBoard(int[][] board, int x, int y, int covered, String trail) {
        final int BEEN = 1;
        final int AVIL = 0;
        int len = board.length;

        if (covered == len * len) {
            System.out.println("solution: \n" + trail);
            return true;
        }

        // cant step to
        if (x < 0 || y < 0 || x >= len || y >= len || board[x][y] == BEEN) {
            return false;
        }

        // mark cell as covered
        board[x][y] = BEEN;
        trail += '(' + x + ',' + y + ')' + "->";
        boolean dir1 = CoverBoard(board, x + 2, y + 1, covered + 1, trail);
        boolean dir2 = CoverBoard(board, x + 1, y + 2, covered + 1, trail);
        boolean dir3 = CoverBoard(board, x - 1, y + 2, covered + 1, trail);
        boolean dir4 = CoverBoard(board, x - 2, y + 1, covered + 1, trail);
        boolean dir5 = CoverBoard(board, x - 2, y - 1, covered + 1, trail);
        boolean dir6 = CoverBoard(board, x - 1, y - 2, covered + 1, trail);
        boolean dir7 = CoverBoard(board, x + 1, y - 2, covered + 1, trail);
        boolean dir8 = CoverBoard(board, x - 1, y + 2, covered + 1, trail);

        // unmark cell
        board[x][y] = AVIL;

        return (dir1 || dir2 || dir3 || dir4 || dir5 || dir6 || dir7 || dir8);
    }
}
