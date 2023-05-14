public class Tester3 {

  public static void main(String[] args) {
    int[] a = { 9, 4, 1, 16 };

    // Tar3.selectionSort(a, 0);
    // System.out.println( Tar1.arr2String(a));
    // Tar3.insertionSort(a);
    // Tar3.bubbleSort(a);
    Tar3.quickSort(a);
    System.out.println(Tar1.arr2String(a));
  }
}
