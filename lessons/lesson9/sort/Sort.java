public class Sort {

  public static void SelectionSort(int[] a) {
    // for each element of a
    for (int i = 0; i < a.length; i++) {
      // find index of smallest from i to the end
      int smalIdx = i;
      for (int j = i; j < a.length; j++) {
        if (a[j] < a[smalIdx]) {
          smalIdx = j;
        }
      }
      // swap smallest with i
      int tmp = a[i];
      a[i] = a[smalIdx];
      a[smalIdx] = tmp;
    }
  }

  public static void insertionSort(int[] a) {
    int tmp;
    int j;
    for (int i = 1; i < a.length; i++) {
      //insert a[i] to its place in the left part
      tmp = a[i];
      j = i;
      while (j > 0 && a[j - 1] > tmp) {
        // move a[j-1] to right
        a[j] = a[j - 1];
        j--;
      }
      // insert tmp to its place
      a[j] = tmp;
    }
  }

  public static void bubbleSort(int[] a) {
    boolean wasSwap = true;
    for (int i = a.length - 1; i > 0 && wasSwap; i--) {
      wasSwap = false;
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          int tmp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = tmp;
          wasSwap = true;
        }
      }
    }
  }
}
