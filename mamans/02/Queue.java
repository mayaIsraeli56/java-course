public class Queue {

  private IntNode _head, _tail;

  public Queue() {
    _head = null;
    _tail = null;
  }

  public boolean isEmpty() {
    return _head == null;
  }

  public void enqueue(int num) {
    IntNode temp = new IntNode(num, null);
    if (_tail != null) _tail.setNext(temp);
    _tail = temp;
    if (_head == null) _head = temp;
  }

  public int dequeue() {
    int temp = _head.getValue();
    _head = _head.getNext();
    return temp;
  }

  public int first() {
    return _head.getValue();
  }

  public String toString() {
    String s = "";
    IntNode temp = _head;
    while (temp != null) {
      s = s + temp.getValue() + "\t";
      temp = temp.getNext();
    }
    return s;
  }

}
