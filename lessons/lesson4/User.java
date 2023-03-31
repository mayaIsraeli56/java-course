public class User {
    public static void main(String[] args) {
        //create new Box
        Box box1 = new Box(4, 3, 2);
        // print the box
        System.out.println("box1 = " + box1);

        // create new Box with negative values
        Box box2 = new Box(0, -1, -7);
        // print the new box, all attributes should be 1
        System.out.println("box2 = " + box2);

        // add 3 for each attribute
        box2.changeSize(3);
        System.out.println("box2 after changeSize(3) = " + box2);
        
        // add -10 to check negativity
        box2.changeSize(-10);
        System.out.println("box2 after changeSize(-10) = " + box2);
        
        System.out.println("box2 volume = " + box2.calcVolume());
        System.out.println("box2 surface = " + box2.calcSurface());
    }

    public static class Box {

        // constants declaration:
        private final int MIN_DEF = 1;

        //attributes declarations:
        private int _length;
        private int _width;
        private int _height;

        //constructors
        public Box(int length, int width, int height) {
            if (length < MIN_DEF) {
                length = MIN_DEF;
            }
            _length = length;
            if (width < MIN_DEF) {
                width = MIN_DEF;
            }
            _width = width;
            if (height < MIN_DEF) {
                height = MIN_DEF;
            }
            _height = height;
        }

        //method definitions
        public String toString() {
            // build and return the String of the object
            return "(" + _length + ", " + _width + ", " + _height + ")";
        }

        public void changeSize(int delta) {
            // change attribute only if valid after adding delta
            if (_length + delta >= MIN_DEF && _width + delta >= MIN_DEF
            && _height + delta >= MIN_DEF) {
                _length += delta;
                _width += delta;
                _height += delta;
            }
        }
        
        public int calcVolume() {
            return _length * _width * _height;
        }

        public int calcSurface() {
            return _length * _width * 2 + _height * _width * 2 +  _length * _height * 2;
        }
    }
}