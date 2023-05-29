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
        return node.getValue(); // returning the node itself and not a copy
    }

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

    public void addToHead(IntNode node) {
        IntNode temp = _head;
        _head = node;
        node.setNext(temp);
    }
}
