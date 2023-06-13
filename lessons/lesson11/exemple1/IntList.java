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

  ///////////////////////////////////////////////////////////////////

  public void addToEnd(IntNode node) {
    if (empty())
      _head = node;
    else {
      IntNode ptr = _head; // pointer
      while (ptr.getNext() != null)
        ptr = ptr.getNext();
      ptr.setNext(node);
    }
  }

  public void add(int num) {
    _head = add(_head, num);
  }

  private IntNode add(IntNode node, int num) {
    if (node == null) {
      return new IntNode(num, null);
    } else {
      node.setNext(add(node.getNext(), num));
      return node;
    }
  }

  ///////////////////////////////////////////////////////////////////

  public void addToHead(IntNode node) {
    IntNode temp = _head;
    _head = node;
    node.setNext(temp);
  }

  public void remove(int num) {
    if (_head != null) {

      if (_head.getValue() == num)
        _head = _head.getNext();

      else {
        IntNode behind = _head;
        while (behind.getNext() != null) {
          if (behind.getNext().getValue() == num) {
            behind.setNext(behind.getNext().getNext());
            return;
          } else
            behind = behind.getNext();
        } // of while
      } // of else ( num is not in _head)
    } // of if ( list is not empty)
  } // of the method

  ///////////////////////////////////////////////////////////////////
  public void printList() {
    IntNode temp = _head;
    while (temp != null) {
      System.out.print(temp.getValue() + " --> ");
      temp = temp.getNext();
    }
    System.out.println(" null");
  }

  public void printRec() {
    System.out.println("The list is: ");
    printRec(_head);
  }

  private void printRec(IntNode p) {
    if (p == null) {
      System.out.println(" null ");
      return;
    } else {
      System.out.print(p.getValue() + " --> ");
      printRec(p.getNext());
    }
  }

  ///////////////////////////////////////////////////////////////////

  public int length() {
    IntNode temp = _head;
    int count = 0;
    while (temp != null) {
      count++;
      temp = temp.getNext();
    }
    return count;
  }

  public int lengthRec() {
    return lengthRec(_head);
  }

  private int lengthRec(IntNode p) {
    if (p == null)
      return 0;
    return 1 + lengthRec(p.getNext());
  }

  ///////////////////////////////////////////////////////////////////

  public IntNode predecessor(IntNode node) {
    if (_head == null || _head == node)
      return null;
    IntNode behind = _head;
    while (behind.getNext() != null) {
      if (behind.getNext() == node)
        return behind;
      else
        behind = behind.getNext();
    }
    return null;
  }

  public boolean equals(IntList other) {

    if (this.length() != other.length())
      return false;

    IntNode temp1 = _head;
    IntNode temp2 = other._head;

    while (temp1 != null && temp2 != null) {

      if (temp1.getValue() != temp2.getValue())
        return false;

      temp1 = temp1.getNext();
      temp2 = temp2.getNext();
    }

    return true;
  }

  public void printMiddle() {
    IntNode s = _head;
    IntNode f = _head;
    if (_head != null) {
      while (f != null && f.getNext() != null) {
        f = f.getNext().getNext();
        s = s.getNext();
      }
      System.out.println(s.getValue());
    }
  }

  public void moveKToEnd(int k) {
    if (k == 0)
      return;
    IntNode c = _head;
    int i = 1;
    while (i < k && c != null) {
      c = c.getNext();
      i++;
    }
    if (c == null)
      return;
    IntNode temp = c;
    while (c.getNext() != null)
      c = c.getNext();
    c.setNext(_head);
    _head = temp.getNext();
    temp.setNext(null);
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
    if (k == 0)
      return;
    IntNode c = _head;
    int i = 1;
    while (i < k && c != null) {
      c = c.getNext();
      i++;
    }
    if (c == null)
      return;
    IntNode temp = c;
    while (c.getNext() != null)
      c = c.getNext();
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

  //////////////////////////////////////////////////////////////////////

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

  public boolean addInOrderRec(int num) {
    return addInOrderRec(_head, num);
  }

  private IntNode addInOrderRec2(IntNode p, int num) {
    if (p == null)
      return new IntNode(num);
    if (p.getValue() > num)
      return new IntNode(num, p);
    p.setNext(addInOrderRec(p.getNext(), num));
    return p;
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

  //////////////////////////////////////////////////////////////////////////////////
  public IntNode find(int num) {
    if (empty())
      return null;
    IntNode current = _head;
    return find(num, current);
  }

  private IntNode find(int num, IntNode current) {
    if (current == null)
      return null;
    if (current.getValue() == num)
      return current;
    current = current.getNext();
    return find(num, current);
  }

  //////////////////////////////////////////////////////////////////////////////////

  public IntNode secondMax() {
    if (length() < 2)
      return null;
    IntNode max, sec;
    if (_head.getValue() > _head.getNext().getValue()) {
      max = _head;
      sec = _head.getNext();
    } else {
      max = _head.getNext();
      sec = _head;
    }
    return secondMax(max, sec, _head.getNext().getNext());
  }

  private IntNode secondMax(IntNode max, IntNode sec, IntNode current) {
    if (current == null)
      return sec;
    if (current.getValue() > max.getValue()) {
      sec = max;
      max = current;
    } else if (current.getValue() > sec.getValue()) {
      sec = current;
    }
    return secondMax(max, sec, current.getNext());
  }

  //////////////////////////////////////////////////////////////////////////////////
  public void printDouble() {
    if (empty())
      return;
    printDouble(_head);
  }

  private void printDouble(IntNode current) {

    if (current == null)
      return;
    System.out.print(current.getValue() + " ");
    printDouble(current.getNext());
    System.out.print(current.getValue() + " ");
  }

  ////////////////////////////// mergeSort//////////////////////////////////////////
  public void mergeSort() {
    _head = mergeSort(_head);
  }

  private IntNode mergeSort(IntNode node) {
    if (node == null || node.getNext() == null)
      return node; // checks for empty or single list
    IntNode list2 = split(node);
    node = mergeSort(node);
    list2 = mergeSort(list2);
    return merge(node, list2);
  } // end merge_sort

  private IntNode split(IntNode node) {
    if (node == null || node.getNext() == null)
      return null;
    IntNode list2 = node.getNext();
    node.setNext(list2.getNext());
    list2.setNext(split(list2.getNext()));
    return list2;
  }

  private static IntNode merge(IntNode list1, IntNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;
    if (list1.getValue() < list2.getValue()) {
      list1.setNext(merge(list1.getNext(), list2));
      return list1;
    } else {
      list2.setNext(merge(list1, list2.getNext()));
      return list2;
    }
  }
  ////////////////////////////////////////////////////////////////////////
}
