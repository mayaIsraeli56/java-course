public class CharNode {

  private char _value;
  private CharNode _next;

  public CharNode(char val) {
    _value = val;
    _next = null;
  }

  public CharNode(char val, CharNode next) {
    _value = val;
    _next = next;
  }

  public char getValue() {
    return _value;
  }

  public void setValue(char v) {
    _value = v;
  }

  public CharNode getNext() {
    return _next;
  }

  public void setNext(CharNode node) {
    _next = node;
  }
} // end of class CharNode
