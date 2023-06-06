public class IntList {

  private IntNode _head;

  public IntList() {
    _head = null;
  }

  public IntList(IntNode node) {
    _head = node;
  }

  public boolean empty() {
    return _head == null;
  }

  public IntNode nextElement(IntNode node) {
    return node.getNext(); // returning the node itself and not a copy
  }

  public int getValueOfNode(IntNode node) {
    return node.getValue(); // returning the int value
  }

  public void addToEnd(IntNode node) {
    if (empty()) _head = node; else {
      IntNode ptr = _head; // pointer
      while (ptr.getNext() != null) ptr = ptr.getNext();
      ptr.setNext(node);
    }
  }

  public void addToHead(IntNode node) {
    IntNode temp = _head;
    _head = node;
    node.setNext(temp);
  }

  public void moveFromStartToEnd(int k) {
    if (k == 0) return;
    IntNode c = _head;
    int i = 1;
    while (i < k && c != null) {
      c = c.getNext();
      i++;
    }
    if (c == null) return;
    IntNode temp = c;
    while (c.getNext() != null) c = c.getNext();
    c.setNext(_head);
    _head = temp.getNext();
    temp.setNext(null);
  }
}
