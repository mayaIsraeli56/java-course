package Box;

public class BoxCatalog {
    public static final int MAX_BOXES = 100;
    private Box[] _boxes;
    private int _noBoxes;

    public BoxCatalog() {
        // create the array with MAX_BOXES boxes
        _boxes = new Box[MAX_BOXES];
        _noBoxes = 0;
    }
    // methods:

    public boolean add(int length, int width, int height) {
        // check for place in array
        if (_noBoxes == _boxes.length) {
            return false;
        }
        // generate the new box
        Box newBox = new Box(length, width, height);
        // check if already exist in array
        if (indexOf(newBox) != -1) { // found
            return false;
        }
        // add the new box
        _boxes[_noBoxes] = newBox;
        // Increase num of boxes
        _noBoxes++;
        return true;
    }

    // return the index of box b, -1 if not found
    private int indexOf(Box b) {
        for (int i = 0; i < _noBoxes; i++) {
            if (b.equals(_boxes[i])) { // found
                return i;
            }
        }
        // not found
        return -1;
    }

    public String toString() {
        if (_noBoxes == 0) {
            // empty array
            return "Empty Catalog";
        }
        String str = "Boxes Catalog";
        for (int i = 0; i < _noBoxes; i++) {
            // add box in boxes[i] to the String
            str += "\n" + _boxes[i].toString();
        }
        // finish - return the string
        return str;
    }

    public Box remove(int length, int width, int height) {
        // generate the box
        Box b = new Box(length, width, height);
        int index = indexOf(b);
        if (index == -1) {
            // not found
            return null;
        }
        // found the box - take it out
        Box tmp = _boxes[index];
        // close the "hole"
        _boxes[index] = _boxes[_noBoxes - 1];
        _noBoxes--;
        return tmp;
    }

    public Box search(int length, int width, int height) {
        Box b = new Box(length, width, height);
        int index = indexOf(b);
        if (index != -1) {
            // found -> return the box in index
            return _boxes[index];
        }
        // not found -> return null
        return null;
    }

    public Box maxVolume() {
        if (_noBoxes == 0) {
            // empty array
            return null;
        }
        Box max = _boxes[0];
        for (int i = 1; i < _noBoxes; i++) {
            if (_boxes[i].bigger(max)) {
                // current box bigger the max
                max = _boxes[i];
            }
        }
        return max;
    }

    public Box bestBox(int length, int width, int height) {
        Box best = null;
        for (int i=0; i<_noBoxes; i++) {
        if (_boxes[i].getLength() > length &&
        _boxes[i].getWidth() > width &&
        _boxes[i].getHeight() > height) {
        //current box is fit
        if (best==null || best.bigger(_boxes[i])) {
        // found better box
        best = _boxes[i];
        }
        }
        }// for
        return best;
        }
        
}
