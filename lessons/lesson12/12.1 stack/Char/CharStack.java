public class CharStack {

  private CharNode _top;

  public CharStack() {
    _top = null;
  }

  public boolean isEmpty() {
    return _top == null;
  }

  public void push(char num) {
    _top = new CharNode(num, _top);
  }

  public char pop() {
    char temp = _top.getValue();
    _top = _top.getNext();
    return temp;
  }

  public int top() {
    char temp = pop();
    push(temp);
    return temp;
  }

  //     public int top() {
  //     int temp = _top.getValue();
  //     return temp;
  //   }

  public String toString() {
    String s = "";
    CharStack s1 = new CharStack();
    while (!isEmpty()) {
      char temp = pop();
      s1.push(temp);
      s = s + temp + "\t";
    }
    while (!s1.isEmpty()) {
      char temp = s1.pop();
      push(temp);
    }
    return s;
  }

//   public String toString() {
//     String s = "";
//     CharNode temp = _top;
//     while (temp != null) {
//       s = s + temp.getValue() + "\t";
//       temp = temp.getNext();
//     }
//     return s;
//   }
}
