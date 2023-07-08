/*#Shadi:
 * grade 100/100
 */
/**
 * Ex14.java - complexity and recursion problems.
 * id: 209956333
 *
 * @author Maya Israeli
 * @version 25.5.2023
 */

public class Ex13 {

    // constants
    private static final int RESET = 0; // reset variable

    private static final int STEP = 1; // The basic number for changing variables
    private static final int SHORTST_PALINDROME = 1; // The length of the shortest palindrome

    private static final int AVE_FACTORS = 2; // factors in the average
    private static final int MAX_IN_A_ROW = 2; // max adjacent cells that can be subtracted

    // Q1
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The method returns driving duration in minutes on the shortest route from A
     * to B.
     * The method receives two one-dimensional arrays describing a trip from A to B.
     * Each element i in the array is equal to the number of minutes it takes to
     * travel on section i of the road.
     * The driver can start on road 1 or road 2, and can cross a road at most once.
     *
     * Time Complexity: O(n) -
     * Tterating once over road1 and road2 (at the same time) to sum up their
     * elements.
     * Iterating over the arrays once to find the optimal exchange point.
     * Total of 2 itetations, no nested loops. O(n + n) = O(n).
     *
     * Space Complexity: O(1) - constant number of variables.
     *
     * @param road1 array of positive integers, element i in the array represents
     *              the driving duration on section i of road 1.
     * @param road2 array of positive integers, element i in the array represents
     *              the driving duration on section i of road 2.
     * @return integer that represents the travel time in minutes on the shortest route from A to B
     */

    public static int shortestRoad(int[] road1, int[] road2) {
        int lastIdx = road1.length - 1; // the roads are in the same length

        int pathR1 = 0; // the driving duration of the routes that starts at road1
        int pathR2 = 0; // the driving duration of the routes that starts at road2

        // sums up the total driving duration for each road - without changing a road
        for (int i = 0; i <= lastIdx; i++) {
            pathR1 += road1[i];
            pathR2 += road2[i];
        }

        int shortest = Math.min(pathR1, pathR2); // saves the shortest driving duration found yet

        /*
         * For each road interchange point (switchPoint) it calculates:
         * 1. Driving duration in a path that starts at road 1 and switch at
         * switchPoint to road 2
         * 2. Driving duration in a path that starts at road 2 and switch at switchPoint
         * to road 1
         * It finds the min between the two and the overall minimum.
         */
        for (
        int switchPoint = lastIdx, currSwitch;
        switchPoint > RESET;
        switchPoint--
        ) {
            // switch the current section
            currSwitch = road2[switchPoint] - road1[switchPoint]; //  difference between the roads at each switch point
            pathR1 += currSwitch;
            pathR2 -= currSwitch;
            shortest = Math.min(shortest, Math.min(pathR1, pathR2)); // save min
        }

        // time in minutes on the shortest route
        return shortest;
    }

    // Q2
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A method that receives a one-dimensional array
     * containing numbers that are part of arithmetic sequence.
     * One number in the series is missing, and the method returns this missing
     * value.
     *
     * Time Complexity: O(logn) -
     * This algorithm is an implementation of Binary search.
     * The algorithm relies on the fact that a missing value creates a disturbance,
     * so the value in each cell that follows, does not match its serial number.
     * In each iteration, the search field in the array is reduced by half (hence logn).
     * It checks if the middle element in the search field is the right value,
     * according to its cell number and the arithmetic sequence formula.
     * If it is not, the skipping has occurred in the first half,
     * if it is, the skipping is in the second half.
     * The missing value is in the remaining part of the array,
     * and only it will be checked in the next iteration.
     *
     * Space Complexity: O(1) -
     * data is saved in constant number of variables. (independent of n, the length of arr)
     *
     * @param arr a one-dimensional array containing numbers that are part of
     *            arithmetic progression,
     *            one number in the series is skipped.
     * @return the missing value in the series.
     */
    public static int missingValue(int[] arr) {
        int len = arr.length;
        int lo = RESET, hi = len - 1; // The indexes that limit the search area
        int diff = (arr[hi] - arr[lo]) / len; // the common difference of successive members
        int mid, a1 = arr[lo];

        while (lo < hi - 1) { // lo and hi are not adjacent
            mid = (lo + hi) / AVE_FACTORS; //  finds the middle
            if (arr[mid] == a1 + mid * diff) { // is it the right value according to the formula?
                lo = mid; //  move to the second half
            } else {
                hi = mid; //  move to the first half
            }
        }

        // the missing value is between lo to hi
        return arr[lo] + diff;
    }

    // Q3
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A recursive method, returns the length of the longest palindromic sequence in
     * a given array.
     *
     * @param arr The array for finding the length of the longest palindromic
     *            sequence in it.
     * @return integer that represents the length of the longest palindromic
     *         sequence in arr (1-arr.length)
     */
    public static int longestPalindrome(int[] arr) {
        return longestPalindrome(arr, RESET, arr.length - 1);
    }

    private static int longestPalindrome(int[] arr, int left, int right) {
        int lastIdx = arr.length - 1; // last index in the array

        // base case - all sequences with a length greater than 1 have been checked and
        // are not palindromes
        if (left == right) {
            return SHORTST_PALINDROME; // the length of the shortest palindrome
        }

        // if the current sequences is a palindrom, it is the longest one in the array
        if (
        arr[left] == arr[right] && isPalindrom(arr, left + STEP, right - STEP)
        ) {
            return right - left + 1; // palindrom length
        }

        /*
         * A recursive call to the function, sending the indexes of the next sequence.
         * If there is another sequence of the same length that has not yet been checked
         * - sends it.
         * Otherwise, sends a sequence that is shorter by one.
         * For each length, the position of "left" starts at the beginning of the array,
         * and the indexes increasing as long as right is not out of bound.
         */
        return (right != lastIdx)
        ? longestPalindrome(arr, left + STEP, right + STEP)
        : longestPalindrome(arr, RESET, right - left - STEP);
    }

    // A boolean method that returns true if the given array is a palindrome
    // between the given indexes
    private static boolean isPalindrom(int[] a, int left, int right) {
        if (left >= right) { // all cells has been checked and did not returned false - it is a palindrom
            return true;
        }

        if (a[left] != a[right]) { // checks if the numbers in the edges are equal
            return false;
        }

        // checks the rest of the sequence without the edges
        return isPalindrom(a, left + STEP, right - STEP);
    }

    // Q4
    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A recursive method, returns true if the recived array have a subset, which
     * fulfills the following conditions:
     * 1. It's members sum is equal to the recived integer (num).
     * 2. A member could be added to the sum no more then once.
     * 3. Every 3 members can not be in adjacent cells in the array.
     *
     * @param arr A one-dimensional array filled with positive integers.
     * @param num An integer, the sum to be reched.
     * @return true if the required subset has been found
     */

    public static boolean isSum(int[] arr, int num) {
        return isSum(arr, num, RESET, RESET);
    }

    /*
     * Returns true if the required subset has been found -
     * For each cell it recursively checks two options subtracting or skipping,
     * while keeping the third rule using a counter.
     */
    private static boolean isSum(int[] arr, int num, int i, int count) {
        // base case - the numbers subtracted from num are the required subset
        if (num == 0) {
            return true;
        }

        /* Arr is full of positive integers so if num is negative it is a dead end.
         * If all cells hava been checked there is no proper subset */
        if (num < 0 || i >= arr.length) {
            return false;
        }

        // "count" watches after the subtractaction of three adjacent cells
        if (count < MAX_IN_A_ROW) { // this cell can be subtracted
            // returns whether the goal can be achieved by subtracting the cell or by skipping
            return (
                isSum(arr, num - arr[i], i + STEP, count + STEP) ||
                isSum(arr, num, i + STEP, RESET)
            );
        }

        // two adjacent cells has already been add - cell must be skipped
        return isSum(arr, num, i + STEP, RESET);
    }
}
