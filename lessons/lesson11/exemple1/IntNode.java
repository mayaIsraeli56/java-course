public class IntNode {

    private int _value;
    private IntNode _next;

    public IntNode(int val) {
        _value = val;
        _next = null;
    }

    public IntNode(int val, IntNode next) {
        _value = val;
        _next = next;
    }

    public int getValue() {
        return _value;
    }

    public void setValue(int v) {
        _value = v;
    }

    public IntNode getNext() {
        return _next;
    }

    public void setNext(IntNode node) {
        _next = node;
    }

    

    // public IntNode merge(IntNode list2) {
    // if (list2 == null)
    // return this; // merge with null
    // if (_value < list2.getValue()) {
    // if (_next == null)
    // return new IntNode(_value, list2); // this has only 1 value, it's smaller
    // than other's head
    // else
    // return new IntNode(_value, merge(list2.getNext())); // this head is smaller,
    // more than 1 value
    // } else
    // return new IntNode(list2.getValue(), merge(list2.getNext())); // other head
    // is smaller
    // }

}
