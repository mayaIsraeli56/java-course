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

  public void removeNode(int val) {
    IntNode prev = null;
    IntNode curr = _head;

    while (curr != null && curr.getValue() != val) {
      prev = curr;
      curr = curr.getNext();
    }

    if (curr != null) {
      if (prev == null) {
        _head = curr.getNext();
      } else {
        prev.setNext(curr.getNext());
      }
    }
  }

  public void recursiveReverse() {
    recursiveReverse(_head, null);
  }

  private void recursiveReverse(IntNode node, IntNode prev) {
    if (node == null) {
      _head = prev;
    } else {
      recursiveReverse(node.getNext(), node);
      node.setNext(prev);
    }
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

  public boolean isThere(int value) {
    return isThere(value, _head);
  }

  public boolean isThere(int value, IntNode node) {
    if (node == null) {
      return false;
    }
    if (node.getValue() == value) {
      return true;
    }
    return isThere(value, node.getNext());
  }

  public void addInOrder(int value) {
    IntNode nodeToAdd = new IntNode(value, null);
    if (empty()) {
      _head = nodeToAdd;
      return;
    }

    IntNode temp = _head;
    while (temp.getNext() != null && temp.getNext().getValue() < value) {
      temp = temp.getNext();
    }

    if (temp == _head) {
      nodeToAdd.setNext(_head);
      _head = nodeToAdd;
    } else {
      nodeToAdd.setNext(temp.getNext());
      temp.setNext(nodeToAdd);
    }
  }

  public String toString() {
    IntNode curr = _head;
    String s = "";
    while (curr != null) {
      s += curr.getValue() + " - ";
      curr = curr.getNext();
    }
    s += curr;
    return s;
  }
}
