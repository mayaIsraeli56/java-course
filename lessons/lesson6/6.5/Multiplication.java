public class Multiplication {
    
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
}