/**
 * Ex14.java - complexity and recursion problems.
 * Author: iDaN
 * Version: 11/05/2021
 */
public class Ex14 {

    // Q1:
    /**
     * Finds the maximal drop between 2 numbers in a given array, such that the larger number is located before the lower.
     * @param a Array of positive integer numbers.
     * @return The maximum difference between 2 numbers in the array (the bigger number is located first).
     *
     * Time Complexity: O(n) - iterating over the array only once.
     * Space Complexity: O(1) - constant number of variables.
     */
    public static int maximalDrop(int[] a) {
        final int DEFAULT_VAL = 0;

        if (a.length < 2)
            return DEFAULT_VAL;

        int maxDrop = Math.max(DEFAULT_VAL, a[0] - a[1]), maxNum = a[0];
        // iterating n-2 times and setting the max drop as the max difference between the maximum number (before the lower) to the next number.
        for (int i = 1; i < a.length - 1;) {
            maxNum = Math.max(a[i], maxNum);
            maxDrop = Math.max(maxDrop, maxNum - a[++i]); // ++i here, instead of a[i + 1] and i++ at the loop increment statement.
        }

        return Math.max(DEFAULT_VAL, maxDrop);
    }// end of Q1.

    // Q2:
    /**
     * Finds the row/column number of the sink or -1 if no sink was found.
     * @param mat 2-Dimensional array of 2 values (1 or 0)
     * @return The row/column number of the sink
     *
     * Time Complexity: O(2n + n)  = O(n)  - no nested loops.
     * Space Complexity: O(1)  - constant number of variables.
     * There is only 1 sink at most and n options for the sink.
     * At first, traversing the matrix diagonally to invalidate the row / column. if we invalidated the last row, we can assume that there is no sink.
     * Otherwise - the last row that was reached, might be the sink, so we can check it with the corresponding column.
     */
    public static int isSink(int[][] mat) {
        final int NO_SINK = -1, ROW_VAL = 0, COL_VAL = 1;

        // The number of rows is equal to the number of columns, so if there's only 1 row, we can assume that there is no sink if the value is not 0.
        if (mat.length == 1) {
            if (mat[0][0] == ROW_VAL)
                return 0;
            return NO_SINK;
        }

        int row = 0;
        // Moving to the next row if the value is 1 and moving to the next column if 0. in the worst case - iterating 2n times.
        for (int val, col = 0; row < mat.length && col < mat.length; row += val, col -= val)
        // "val" is the value of the current cell (1 or 0)
            val = mat[row][col++]; // col++ here, in order to move to the next column if val is 0 (col -= val at the loop increment statement)

        // if traversed over all the rows, it means that the value 1 was found n times, so there is no sink in the given matrix */
        if (row == mat.length)
            return NO_SINK;

        // here, "row" is the suspected row/column number of the sink (because the last condition wasn't met)
        int sink = row;

        // traversing over the suspected column and row of the sink simultaneously to check if the sink is there. (in the worst case, iterating n times).
        for (int i = 0; i < mat.length; i++)
            if (mat[sink][i] == COL_VAL || (mat[i][sink] == ROW_VAL && i != sink))
                return NO_SINK;

        return sink;
    } // end of Q2.

    // Q3:
    /**
     * Calculates the size of the "stain" in the given cell. (returns 0 if no stain was found)
     *
     * @param mat 2-Dimensional array of boolean values (true / false)
     * @param x   The row number of the given cell.
     * @param y   The column number of the given cell.
     * @return The size of the "stain" of the given cell.
     */
    public static int size(boolean[][] mat, int x, int y) {
        final int DEFAULT_VAL = 0;

        // checking if the given place is valid and not empty (false value)
        if (isInvalid(mat, x, y) || !mat[x][y])
            return DEFAULT_VAL;

        // creating a new matrix for the visited places and calling to the overloaded recursive method.
        boolean[][] visited = new boolean[mat.length][mat[0].length]; // all values are "false" by default.
        return size(mat, visited, x, y);
    }

    private static int size(boolean[][] mat, boolean[][] visited, int row, int col) {
        // base case - checking if the current place is out of range or empty (false) or visited already.
        if (isInvalid(mat, row, col) || !mat[row][col] || visited[row][col])
            return 0;

        // here it's true and hasn't been visited yet, so we can mark this as visited now.
        visited[row][col] = true;

        // making recursive calls for all the adjacent cells.
        int up = size(mat, visited, row-1, col), down = size(mat, visited, row+1, col),
        left = size(mat, visited, row, col-1), right = size(mat, visited, row, col+1);

        // diagonals
        int upLeft = size(mat, visited, row-1, col-1), downLeft = size(mat, visited, row+1, col-1),
        upRight = size(mat, visited, row-1, col+1), downRight = size(mat, visited, row+1, col+1);

        return 1 + up + down + left + right + upLeft + downLeft + upRight + downRight;
    }

    private static boolean isInvalid(boolean[][] mat, int row, int col) {
        // checking if the current row and col are invalid (out of range).
        return row < 0 || col < 0 || row >= mat.length || col >= mat[0].length;
    }// end of Q3.

    // Q4:
    /**
     * Receives 2 arrays to check if they are permutations of each other.
     *
     * @param a The first array of integer numbers.
     * @param b The array to check if it's a permutation of the other.
     * @return true iff the first array is a permutation of the other.
     */
    public static boolean isPermutation(int[] a, int[] b) {
        final int STARTING_INDEX = 0;

        // returns false if the arrays are invalid or they don't have the same length.
        if (a == null || b == null || a.length != b.length)
            return false;
        // here, the arrays are valid and have the same length.
        
        if (a.length == 0)
            return true;

        // if the arrays contain only 1 number, we can compare it and return the result.
        if (a.length == 1)
            return a[0] == b[0];

        // creating an array of boolean values for the visited indexes, and sending it to the overloaded recursive method.
        boolean[] visited = new boolean[a.length]; // all values are "false" by default.
        return isPermutation(a, b, visited, STARTING_INDEX, STARTING_INDEX);
    }

    private static boolean isPermutation(int[] a, int[] b, boolean[] visited, int aIdx, int bIdx) {
        // base case - if checked all numbers in the first array without returning false, then it should return true.
        if (aIdx == a.length)
            return true;

        // returns false if a matching number wasn't found.
        if (bIdx == a.length)
            return false;

        // checking if the current numbers are equal and haven't been visited yet
        if (a[aIdx] == b[bIdx] && !visited[bIdx]) {
            visited[bIdx] = true;
            return isPermutation(a, b, visited, aIdx + 1, 0);
        }

        // here, the numbers are not equal (or visited already) so it should check the next number.
        return isPermutation(a, b, visited, aIdx, bIdx + 1);
    }// end of Q4.
}