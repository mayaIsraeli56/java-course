public class Tester {

  public static void main(String[] args) {
    int[] a1 = { 1, 1, 2, 0 };
    int[] a2 = { 0, 0, 3, 4 };
    int[] a3 = { 1, 2, 2, 2, 0, 1, 1, 0, 2, 1, 0 };
    int[] a4 = { 1, 2,3,4,5,6,7,8,6,5,4,2 };

    Tar1.sortMod5B(a1);
    Tar1.sortMod5B(a1);
    System.out.println(Tar1.findMaxofUpDownArray(a4));

    Tar1.sortMod5B(a2);
    Tar1.sortMod5B(a3);
    System.out.println(a3);
  }
}
