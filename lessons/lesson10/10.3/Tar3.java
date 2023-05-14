public class Tar3 {

  public static int smallest(int[] a, int i) {
    if (i == a.length - 1) return i;

    int restSmallest = smallest(a, i + 1);

    if (a[i] < a[restSmallest]) {
      return i;
    }

    return restSmallest;
  }

  public static void selectionSort(int[] a, int i) {
    if (i == a.length - 1) {
      return;
    }

    int smallest = smallest(a, i);

    if (i != smallest) {
      int tmp = a[i];
      a[i] = a[smallest];
      a[smallest] = tmp;
    }

    selectionSort(a, i + 1);
  }

  public static void selectionSort(int[] a) {
    selectionSort(a, 0);
  }

  public static void insertionSortLoop(int[] a) {
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

  public static void insertionSort(int[] a) {
    insertionSort(a, 1);
  }

  public static void insertionSort(int[] a, int i) {
    if (i == a.length) {
      return;
    }

    insertBySize(a, i, a[i]);
    insertionSort(a, i + 1);
  }

  public static void insertBySize(int[] a, int i, int tmp) {
    if (i == 0) {
      a[0] = tmp;
    } else if (a[i - 1] > tmp) {
      a[i] = a[i - 1];
      insertBySize(a, i - 1, tmp);
    } else {
      a[i] = tmp;
    }
  }

  public static void bubbleSortLoop(int[] a) {
    for (int i = a.length - 1; i > 0; i--) {
      // from 0 to i, bubble the bigger
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          //swap a[j] with a[j+1]
          int tmp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = tmp;
        }
      }
    }
  }

  public static void bubbleSort(int[] a) {
    bubbleSort(a, a.length - 1);
  }

  public static void bubbleSort(int[] a, int i) {
    if (i == 0) {
      return;
    }

    biggestToEnd(a, i, 0);
    bubbleSort(a, i - 1);
  }

  public static void biggestToEnd(int[] a, int i, int j) {
    if (j == i) {
      return;
    }

    if (a[j] > a[j + 1]) {
      //swap a[j] with a[j+1]
      int tmp = a[j];
      a[j] = a[j + 1];
      a[j + 1] = tmp;
    }
    biggestToEnd(a, i, j + 1);
  }

  /////////////////////quichSort////////////////////////

  public static void quickSort(int[] a) {
    quickSort(a, 0, a.length - 1);
  }

  public static void quickSort(int[] a, int low, int high) {
    if (low < high) {
      int m = partition(a, low, high);
      quickSort(a, low, m - 1);
      quickSort(a, m + 1, high);
    }
  }

  public static int partition(int[] a, int low, int high) {
    int pivot = a[low];
    int right = high, left = low;

    while (left < right) {
      while (left < right && a[left] <= pivot) {
        left++;
      }
      while (a[right] > pivot) {
        right--;
      }

      if (left < right) {
        swap(a, right, left);
      }
      swap(a, right, low);
    }

    return right;
  }

  public static void swap(int[] a, int i, int j) {
    int tmp = a[j];
    a[j] = a[i];
    a[i] = tmp;
  }
}
