public class Teaster {
    public static void main(String[] args) {
        IntList l1, l2;

        IntNode n1 = new IntNode(1);
        IntNode n2 = new IntNode(2);

        l1 = new IntList(n1);
        l1.addToEnd(new IntNode(4));
        l1.addToEnd(new IntNode(2));
        l1.addToEnd(new IntNode(0));

        l2 = new IntList(n2);
        l2.addToEnd(new IntNode(4));
        l2.addToEnd(new IntNode(6));
        l2.addToEnd(new IntNode(8));

        l1.mergeSort();
        System.out.println(l1.toString());
        System.out.println(l2.toString());
    }
}
