public class Node {

  private int _number;
  private Node _leftSon, _rightSon;

  // constructor
  public Node(int number) {
    _number = number;
    _leftSon = null;
    _rightSon = null;
  }

  // the get methods
  public int getNumber() {
    return _number;
  }

  public Node getLeftSon() {
    return _leftSon;
  }

  public Node getRightSon() {
    return _rightSon;
  }

    // the set methods
  public void setNumber(int number) {
    _number = number;
  }

  public void setLeftSon(Node node) {
    _leftSon = node;
  }

  public void setRightSon(Node node) {
    _rightSon = node;
  }

}
