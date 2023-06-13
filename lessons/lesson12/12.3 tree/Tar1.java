public class Tar1 {

  public static boolean search(Node root, int num) { // returns true if num is in tree, false otherwise
    if (root == null) return false;
    if (root.getNumber() == num) return true;
    return search(root.getLeftSon(), num) || search(root.getRightSon(), num);
  }

  // PreOrder print root -> left -> right
  public static void printPreOrder(Node root) {
    if (root != null) {
      System.out.print(root.getNumber() + " ");
      printPreOrder(root.getLeftSon());
      printPreOrder(root.getRightSon());
    }
  }

  // PreOrder left -> print root -> right
  public static void printInOrder(Node root) {
    if (root != null) {
      printInOrder(root.getLeftSon());
      System.out.print(root.getNumber() + " ");
      printInOrder(root.getRightSon());
    }
  }

  // PreOrder left -> right -> print root
  public static void printPostOrder(Node root) {
    if (root != null) {
      printPostOrder(root.getLeftSon());
      printPostOrder(root.getRightSon());
      System.out.print(root.getNumber() + " ");
    }
  }

  public static int sum(Node n) {
    if (n == null) return 0;
    return (n.getNumber() + sum(n.getLeftSon()) + sum(n.getRightSon()));
  }

  public static int countLeaves(Node n) {
    if (n == null) return 0;
    if ((n.getLeftSon() == null) && (n.getRightSon() == null)) return 1;
    return (countLeaves(n.getLeftSon()) + countLeaves(n.getRightSon()));
  }

  public static int countNodes(Node n) {
    if(n==null) return 0;

    return countNodes(n.getLeftSon()) + countNodes(n.getRightSon()) +1;
  }

  public static int treeDepth(Node n) {
    if(n==null) return 0;

    return Math.max(treeDepth(n.getLeftSon()), treeDepth(n.getRightSon())) +1;
  }
}
