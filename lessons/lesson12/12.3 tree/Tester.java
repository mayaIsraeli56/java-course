public class Tester {

  public static void main(String[] args) {
    Node b = new Node(15);
    BST bst = new BST(b);

    Tar2.insert(b, 10);
    Tar2.insert(b, 2);
    Tar2.insert(b, 14);
    Tar2.insert(b, 18);
    Tar2.insert(b, 30);
    Tar2.insert(b, 12);
    Tar2.insert(b, 25);
    Tar2.insert(b, 13);

    Tar1.printPreOrder(b);
    System.out.println(Tar2.is2SearchTre(b, Integer.MIN_VALUE, Integer.MAX_VALUE));
    System.out.println(Tar1.countNodes(b));
    System.out.println(Tar1.treeDepth(b));
    System.out.println();

    bst.addInOrder(0);
       Tar1.printPreOrder(b);
  }
}
