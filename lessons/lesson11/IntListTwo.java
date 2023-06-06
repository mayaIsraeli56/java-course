public class IntListTwo {

  private IntNodeTwo _head, _tail;

  public IntListTwo() {
    _head = null;
    _tail = null;
  }

  public IntListTwo(IntNodeTwo node) {
    _head = node;
    _tail = null;
  }

  public void insertAfter(int num, IntNodeTwo node) {
    IntNodeTwo temp = new IntNodeTwo(num);

    if (_head == null) {
      _head = temp;
      _tail = _head;
    } else {
      IntNodeTwo curr = _head;

      while (curr != node) {
        curr = curr.getNext();
      }

      temp.setNext(curr.getNext());
      temp.setPrev(curr);
      curr.setNext(temp);

      if (temp.getNext() == null) {
        _tail = temp;
      } else {
        temp.getNext().setPrev(temp);
      }
    }
  }

  public void removeInt(IntNodeTwo node) {
    IntNodeTwo curr = _head;
    while (curr != node && curr != null) {
      curr = curr.getNext();
    }

    if (curr == null) {
      return;
    }

    IntNodeTwo after = curr.getNext();
    IntNodeTwo before = curr.getPrev();

    if (before == null) {
      _head = after;
    } else {
      before.setNext(after);
    }

    if (after == null) {
      _tail = before;
    } else {
      after.setPrev(before);
    }
  }

  public static boolean findElementInList(int value, IntNodeTwo node) {

    while(node != null) {
      if (node.getValue() == value) return true;
      node = node.getNext();
    }

    return false;
  }

  public void addBeforeInt(IntNodeTwo node, IntNodeTwo nodeToAdd) {
    IntNodeTwo curr = _head;

    while (curr != node && curr != null) {
      curr = curr.getNext();
    }

    IntNodeTwo before = node.getNext();

    if (before == null) {
      nodeToAdd.setNext(node);
      node.setPrev(nodeToAdd);
      nodeToAdd.setPrev(null);
      _head = nodeToAdd;
    } else {
      before.setNext(nodeToAdd);
      nodeToAdd.setNext(node);
      node.setPrev(nodeToAdd);
      nodeToAdd.setPrev(before);
    }
  }

  public void rearrange() {
    IntNodeTwo left = _head;
    IntNodeTwo right = _tail;
    while (left != right) {
      if (left.getNum() < 0) left = left.getNext(); else if (
        right.getNum() > 0
      ) right = right.getPrev(); else {
        int temp = left.getNum();
        left.setNum(right.getNum());
        right.setNum(temp);
      }
    }
  }

  public boolean empty() {
    return _head == null;
  }

  public void addToEnd(IntNodeTwo node) {
    if (empty()) {
      _head = node;
    } else {
      IntNodeTwo ptr = _head; // pointer
      while (ptr.getNext() != null) {
        ptr = ptr.getNext();
      }
      ptr.setNext(node);
      node.setPrev(ptr);
    }
  }

  public String toString() {
    IntNodeTwo curr = _head;
    String s = curr.getPrev() + " - ";
    while (curr != null) {
      s += curr.getNum() + " - ";
      curr = curr.getNext();
    }
    s += curr;
    return s;
  }
}
