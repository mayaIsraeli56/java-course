/////////////////////////////// BINARY SEARCH //////////////////

public class Tar2 {

  // returns true if num is in Binary Search Tree, false otherwise
  public static boolean searchInBST(Node root, int num) {
    if (root == null) return false;
    if (root.getNumber() == num) return true;
    if (root.getNumber() > num) {
      return searchInBST(root.getLeftSon(), num);
    } else return searchInBST(root.getRightSon(), num);
  }

  // insert to a given tree
  public static void insert(Node bst, int x) {
    if (bst == null) {
      bst = new Node(x);
      return;
    }

    if (x < bst.getNumber()) {
      if (bst.getLeftSon() == null) bst.setLeftSon(new Node(x)); else insert(
        bst.getLeftSon(),
        x
      );
    } else { // if(x > bst.getNumber())
      if (bst.getRightSon() == null) bst.setRightSon(new Node(x)); else insert(
        bst.getRightSon(),
        x
      );
    }
  }

  public static int maxInTree(Node t) {
    if (t == null) return Integer.MIN_VALUE;
    if (
      (t.getLeftSon() == null) && (t.getRightSon() == null)
    ) return t.getNumber();
    int a = maxInTree(t.getLeftSon());
    int b = maxInTree(t.getRightSon());
    return Math.max(Math.max(a, b), t.getNumber());
  }

  public static int maxInSearchTree(Node root) {
    if (root == null) return Integer.MIN_VALUE;
    if (root.getRightSon() == null) return root.getNumber();
    return maxInSearchTree(root.getRightSon());
  }

  public static boolean is2SearchTre(Node t, int a, int b) {
    if (t == null) return true;
    return (
      t.getNumber() > a &&
      t.getNumber() < b &&
      is2SearchTre(t.getLeftSon(), a, t.getNumber()) &&
      is2SearchTre(t.getRightSon(), t.getNumber(), b)
    );
  }
}
