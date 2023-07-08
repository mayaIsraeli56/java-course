public class TreeNode {

  private int _number;
  private TreeNode _leftSon, _rightSon;

  // constructor
  public TreeNode(int number) {
    _number = number;
    _leftSon = null;
    _rightSon = null;
  }

  // the get methods
  public int getNumber() {
    return _number;
  }

  public TreeNode getLeftSon() {
    return _leftSon;
  }

  public TreeNode getRightSon() {
    return _rightSon;
  }

  // the set methods
  public void setNumber(int number) {
    _number = number;
  }

  public void setLeftSon(TreeNode TreeNode) {
    _leftSon = TreeNode;
  }

  public void setRightSon(TreeNode TreeNode) {
    _rightSon = TreeNode;
  }
}
