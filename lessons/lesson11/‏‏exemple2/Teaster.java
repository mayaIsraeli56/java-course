public class Teaster {
    public static void main(String[] args) {
        IntListTwo l1, l2;

        IntNodeTwo n1 = new IntNodeTwo(1);
        IntNodeTwo n2 = new IntNodeTwo(2);

        l1 = new IntListTwo(n1);
        l1.addToEnd(new IntNodeTwo(4));
        l1.addToEnd(new IntNodeTwo(2));
        l1.addToEnd(new IntNodeTwo(0));

        l2 = new IntListTwo(n2);
        l2.addToEnd(new IntNodeTwo(4));
        l2.addToEnd(new IntNodeTwo(6));
        l2.addToEnd(new IntNodeTwo(8));

        l1.mergeSort();
        System.out.println(l1.toString());
        System.out.println(l2.toString());
    }
}
