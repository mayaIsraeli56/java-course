public class Tester {
    public static void main(String[] args) {
        int[][] a = { { 5, 6, 24 }, { 10, 2, 5, 6 }, { 1, 4, 7, 10 }, { 7, 12, 3, 20 } };
        System.out.println(Tar4.maxSumRow(a));
        System.out.println(Tar4.maxAverageRow(a));
        System.out.println(Tar4.isRowSorte(a, 1));
        System.out.println(Tar4.isAllColsSorte(a));
    }
}
