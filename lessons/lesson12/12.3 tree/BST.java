public class BST {

  private Node _root;

  public BST() {
    _root = null;
  }

  public BST(Node n) {
    _root = n;
  }

  /////////////////////////////////////////////////////////////////////////////////////

  public boolean searchInBST(int num) {
    return searchInBST(_root, num);
  }

  private boolean searchInBST(Node root, int num) {
    if (root == null) return false;
    if (root.getNumber() == num) return true;
    if (root.getNumber() > num) {
      return searchInBST(root.getLeftSon(), num);
    } else return searchInBST(root.getRightSon(), num);
  }

  /////////////////////////////////////////////////////////////////////////////////////

  public void addInOrder(int x) {
    if (_root == null) {
      _root = new Node(x);
      return;
    }

    addInOrder(_root, x);
  }

  private void addInOrder(Node node, int x) {
    if (x < node.getNumber()) {
      if (node.getLeftSon() == null) {
        node.setLeftSon(new Node(x));
      } else {
        addInOrder(node.getLeftSon(), x);
      }
    } else {
      if (node.getRightSon() == null) {
        node.setRightSon(new Node(x));
      } else {
        addInOrder(node.getRightSon(), x);
      }
    }
  }

   /////////////////////////////////////////////////////////////////////////////////////

}
