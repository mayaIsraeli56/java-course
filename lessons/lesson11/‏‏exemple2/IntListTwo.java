
public class IntListTwo {
  private IntNodeTwo _head, _tail;

  public IntListTwo() {
    _head = null;
    _tail = null;
  }

  public void insertAfter(int num, IntNodeTwo node) {
    IntNodeTwo temp = new IntNodeTwo(num);
    if (_head == null) {
      _head = temp;
      _tail = _head;
    } else {
      IntNodeTwo curr = _head;
      while (curr != node)
        curr = curr.getNext();
      temp.setNext(curr.getNext());
      temp.setPrev(curr);
      curr.setNext(temp);
      if (temp.getNext() == null)
        _tail = temp;
      else
        temp.getNext().setPrev(temp);
    }
  }

  // negative - positive
  public void rearrange() {
    IntNodeTwo left = _head;
    IntNodeTwo right = _tail;
    while (left != right) {
      if (left.getNum() < 0)
        left = left.getNext();
      else if (right.getNum() > 0)
        right = right.getPrev();
      else {
        int temp = left.getNum();
        left.setNum(right.getNum());
        right.setNum(temp);
      }
    }
  }

}
