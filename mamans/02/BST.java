public class BST {

  private TreeNode _root;

  public BST() {
    _root = null;
  }

  public BST(TreeNode n) {
    _root = n;
  }

  /////////////////////////////////////////////////////////////////////////////////////

  public boolean searchInBST(int num) {
    return searchInBST(_root, num);
  }

  private boolean searchInBST(TreeNode root, int num) {
    if (root == null) return false;
    if (root.getNumber() == num) return true;
    if (root.getNumber() > num) {
      return searchInBST(root.getLeftSon(), num);
    } else return searchInBST(root.getRightSon(), num);
  }

  /////////////////////////////////////////////////////////////////////////////////////

  public void addInOrder(int x) {
    if (_root == null) {
      _root = new TreeNode(x);
      return;
    }

    addInOrder(_root, x);
  }

  private void addInOrder(TreeNode TreeNode, int x) {
    if (x < TreeNode.getNumber()) {
      if (TreeNode.getLeftSon() == null) {
        TreeNode.setLeftSon(new TreeNode(x));
      } else {
        addInOrder(TreeNode.getLeftSon(), x);
      }
    } else {
      if (TreeNode.getRightSon() == null) {
        TreeNode.setRightSon(new TreeNode(x));
      } else {
        addInOrder(TreeNode.getRightSon(), x);
      }
    }
  }

   /////////////////////////////////////////////////////////////////////////////////////

}
