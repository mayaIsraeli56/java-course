public class Snake2 {
    public static int maxDeadEndSnake(int[][] mat) {
        return maxDeadEndSnake(mat, 0, 0, 0, 0);
    }

    public static int maxDeadEndSnake(int[][] mat, int i, int j, int exI, int exJ) {
        // dead end
        if (i < 0 ||
                i >  mat.length - 1 ||
                j < 0 ||
                j > mat[0].length - 1 ||
                mat[i][j] < 0 ||
                Math.abs(mat[i][j] - Math.abs(mat[exI][exJ])) > 1) {
            return 0;
        }

        // mark the path
        mat[i][j] *= -1;

        // go to 4 directions
        int down = maxDeadEndSnake(mat, i + 1, j, i, j);
        int up = maxDeadEndSnake(mat, i - 1, j, i, j);
        int right = maxDeadEndSnake(mat, i, j + 1, i, j);
        int left = maxDeadEndSnake(mat, i, j - 1, i, j);

        // unmark the path
        mat[i][j] *= -1;

        // return the max path
        int max = Math.max(Math.max(up, down), Math.max(left, right));

        return max + 1;
    }
}
