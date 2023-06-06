public class Tester {

  public static void main(String[] args) {
    // IntNode v1 = new IntNode(1);
    // IntList list = new IntList(v1);

    // list.addToEnd(new IntNode(2));
    // list.addToEnd(new IntNode(3));
    // list.addToEnd(new IntNode(4));

    // IntNode v2 =  new IntNode(2);
    // IntNode v3 = v1;
    // v3 = v2;

    IntNodeTwo t1 = new IntNodeTwo(1);
    IntNodeTwo t2 = new IntNodeTwo(2);
    IntNodeTwo t3 = new IntNodeTwo(3);
    IntNodeTwo t4 = new IntNodeTwo(4);
    IntNodeTwo t5 = new IntNodeTwo(5);
    IntNodeTwo t6 = new IntNodeTwo(6);

    IntListTwo list2 = new IntListTwo(t1);
    System.out.println(list2);

    list2.addToEnd(t2);
    System.out.println(list2);

    list2.addToEnd(t3);
    System.out.println(list2);

    list2.addToEnd(t4);
    System.out.println(list2);

    list2.removeInt(t1);
    System.out.println(list2);

    list2.addToEnd(t6);
    System.out.println(list2);
    list2.addBeforeInt(t6, t5);
    System.out.println(list2);

    System.out.println(IntListTwo.findElementInList(99, t1));
  }
}
