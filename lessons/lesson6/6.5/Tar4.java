public class Tar4 {

    public static void mul(String[] args) {
        int[][] mul = new int[10][12];
        for (int i = 0; i < 10; i++) {// lines
            for (int j = 0; j < 12; j++) { // in line i
                mul[i][j] = (i + 1) * (j + 1);
            }
        }
        // print the array
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                // in line with print
                System.out.print(mul[i][j] + "\t");
            }
            // next line with println
            System.out.println();
        }
    }

    public static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            // print line i
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            // next line
            System.out.println();
        }
    }

    public void swap(int[][] a) {
        int[] tmp;
        for (int i = 0; i < a.length / 2; i++) {
            tmp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = tmp;
        }
    }

    public static int maxSumRow(int[][] a) {

        int maxSum = 0;
        int maxSumIndex = 0;

        for (int i = 0, currSum = 0; i < a.length; i++, currSum = 0) {
            for (int j = 0; j < a[i].length; j++) {
                currSum += a[i][j];
            }

            if (i == 0) {
                maxSum = currSum;
            } else if (maxSum < currSum) {
                maxSum = currSum;
                maxSumIndex = i;
            }
        }

        return maxSumIndex;
    }

    public static int maxAverageRow(int[][] a) {

        int maxAve = 0;
        int maxAveIndex = 0;

        for (int i = 0, currAve = 0; i < a.length; i++, currAve = 0) {
            for (int j = 0; j < a[i].length; j++) {
                currAve += a[i][j];
            }

            currAve /= a[i].length;

            if (i == 0) {
                maxAve = currAve;
            } else if (maxAve < currAve) {
                maxAve = currAve;
                maxAveIndex = i;
            }
        }

        return maxAveIndex;
    }

    public static boolean isRowSorte(int[][] a, int r) {
        if (r >= a[r].length)
            return false;

        boolean isSorted = true;
        int j = 0;

        while (j < a[r].length - 1 && isSorted) {
            if (a[r][j] > a[r][j + 1])
                isSorted = false;
            j++;
        }

        return isSorted;
    }

    public static boolean isAllRowsSorte(int[][] a) {

        boolean isSorted = true;

        for (int i = 0; i < a.length && isSorted; i++) {
            for (int j = 0; j < a[i].length - 1; j++) {
                if (a[i][j] > a[i][j + 1])
                    isSorted = false;
            }
        }
        return isSorted;
    }

    public static boolean isAllRowsSorte2(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            if(!isRowSorte(a,i))
                return false; 
        }
        return true;
    }

    public static boolean isColSorte(int[][] a, int c) {

        for (int i = 0; i < a.length -1; i++) {
           if(a[i][c] > a[i+1][c])
            return false;
        }
        return true;
    }

    public static boolean isAllColsSorte(int[][] a) {

        for (int j = 0; j < a[0].length; j++) {
           if(!isColSorte(a,j))
            return false;
        }
        return true;
    }
}
