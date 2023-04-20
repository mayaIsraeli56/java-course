import java.util.Scanner;

public class Tar0 {
    public static void ArrChangeOrder(int[] arr) {

        for (int temp, i = 0, j = arr.length - 1; i < arr.length / 2; i++, j = arr.length - 1 - i) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        ArrToStringPrint(arr);
    }

    public static void ArrToStringPrint(int[] arr) {

        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    public static void ToBinary(int n) {
        String n2 = "";
        do {
            n2 = (n % 2) + n2;
            n /= 2;
        } while (n > 0);
        System.out.println(n2);
    }

    public static void Swap(int[] a, int i, int j) {

        if (i < 0 || j > 0 || i >= a.length || j >= a.length)
            return;

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        ArrToStringPrint(a);
    }

    public static int maxFirstLast(int[] m) {
        return Math.max(m[0], m[m.length - 1]);
    }

    public static int[] getFirstLast(int[] m) {
        int[] a = { m[0], m[m.length - 1] };
        return a;
    }

    public static double med(double[] m) {
        if (m.length % 2 == 0)
            return (m[m.length / 2 - 1] + m[m.length / 2]) / 2.0;
        return m[m.length / 2];
    }

    public static int[] mergeStartEnd(int[] a, int[] b) {
        return FindMinMax(connect2Arr(a, b));
    }

    private static int[] FindMinMax(int[] a) {
        int min = a[0], max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min > a[i])
                min = a[i];
            if (max < a[i])
                max = a[i];
        }

        int[] arrMinMax = { min, max };
        return arrMinMax;
    }

    public static int[] connect2Arr(int[] a, int[] b) {
        int length = a.length + b.length;
        int[] m = new int[length];

        for (int i = 0; i < length; i++) {
            if (i < a.length)
                m[i] = a[i];
            else
                m[i] = b[i - a.length];
        }

        return m;
    }

    public static void Create100Arr() {
        int cellNum = 100;
        int[] a = new int[cellNum];
        Scanner s = new Scanner(System.in);
        int i = 0, sum = 0;

        while(i< cellNum && sum <= cellNum ) {
            System.out.println("give me the " + (i + 1) + "'s num");
            a[i]  = s.nextInt();
            sum += a[i] ;
            i++;
        }
        
        System.out.println("you filled " + (i+1) + " cells in the array");
        System.out.println("the sum is " + sum);
        s.close();
    }

    public static void oddCoupele(int[] a) {
       
        for (int i=0 ; i< a.length-1 ; i++) {
            if((a[i] + a[i+1]) % 2 != 0)
                System.out.println(" (" + a[i] + "," + a[i+1] + ")");
        }

    }
}