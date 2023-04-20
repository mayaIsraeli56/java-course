package Box;

/**
 * This class represent a three-dimension box.
 * The sides are integers value start by 1.
 * The default size is 10*10*10.
 *
 * @version v.0.1
 * @author Shaul
 *
 */

public class Box {
    // constants declaration:
    private final int MIN_DEF = 1;
    private final int DEF_VAL = 10;

    // attributes declarations:
    private int _length;
    private int _width;
    private int _height;

    /**
     * Constructor for create new box, getting the size of each side.
     *
     * @param length the length of the box, must be at least 1.
     *               if value will be less than 1, it will be changed to 1.
     * @param width  the width of the box, must be at least 1.
     *               if value will be less than 1, it will be changed to 1.
     * @param height the height of the box, must be at least 1.
     *               if value will be less than 1, it will be changed to 1.
     */

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

    /**
     * Constructor for create new box, getting the size of each side.
     *
     * @param length the length of the box, must be at least 1.
     *               if value will be less than 1, it will be changed to 1.
     * @param width  the width of the box, must be at least 1.
     *               if value will be less than 1, it will be changed to 1.
     */

    public Box(int length, int width) {
        if (length < MIN_DEF) {
            length = MIN_DEF;
        }
        _length = length;
        if (width < MIN_DEF) {
            width = MIN_DEF;
        }
        _width = width;
        _height = DEF_VAL;
    }

    /**
     * Copy constructor to create a new box.
     * The size of each side will be the same as those of the given box.
     */

    public Box(Box other) {
        _length = other._length;
        _width = other._width;
        _height = other._height;
    }

    /**
     * Default constructor to create a new box.
     * The size of each side will be the default size - 10
     */
    public Box() {
        _length = DEF_VAL;
        _width = DEF_VAL;
        _height = DEF_VAL;
    }

    // method definitions

    // getters

    /**
     * return the length of the box
     *
     * @return the length of the box
     */
    public int getLength() {
        return _length;
    }

    /**
     * return the width of the box
     *
     * @return the width of the box
     */
    public int getWidth() {
        return _width;
    }

    /**
     * return the height of the box
     *
     * @return the height of the box
     */
    public int getHeight() {
        return _height;
    }

    // setters

    /**
     * change the length of the box to a given new length
     *
     * @param length new length, the length will be changed if and only if
     *               the new length will be at least 10.
     */
    public void setLength(int length) {
        if (length >= DEF_VAL) {
            _length = length;
        }
    }

    /**
     * change the width of the box to a given new width
     *
     * @param width new width, the width will be changed if and only if
     *              the new width will be at least 10.
     */
    public void setWidth(int width) {
        if (width >= DEF_VAL) {
            _width = width;
        }
    }

    /**
     * change the height of the box to a given new height
     *
     * @param height new height, the height will be changed if and only if
     *               the new height will be at least 10.
     */
    public void setHeight(int height) {
        if (height >= DEF_VAL) {
            _height = height;
        }
    }

    /**
     * build and return the String of the object
     *
     * @return the String of the object
     */
    public String toString() {
        return "(" + _length + ", " + _width + ", " + _height + ")";
    }

    /**
     * @param delta
     *              change the length, width and height by delta
     *              only if valid after adding delta
     *
     * @return the String of the object
     */
    public void changeSize(int delta) {
        if (_length + delta >= MIN_DEF && _width + delta >= MIN_DEF
                && _height + delta >= MIN_DEF) {
            _length += delta;
            _width += delta;
            _height += delta;
        }
    }

    /**
     * change the dimensions of the box by the given values
     * 
     * @param deltaLength change the length by the given value deltaLength
     * @param deltaWidth  change the length by the given value deltaWidth
     * @param deltaHeight change the length by the given value deltaHeight
     *                    the changes will happen only if all 3 value are valid
     *                    after adding delta
     *
     * @return the String of the object
     */
    public void changeSize(int deltaLength, int deltaWidth, int deltaHeight) {
        // change attribute only if valid after adding delta
        if (_length + deltaLength >= MIN_DEF &&
                _width + deltaWidth >= MIN_DEF &&
                _height + deltaHeight >= MIN_DEF) {
            _length += deltaLength;
            _width += deltaWidth;
            _height += deltaHeight;
        }
    }

    /**
     * the volume of the box
     * 
     * @return the volume of the box
     */
    public int calcVolume() {
        return _length * _width * _height;
    }

    /**
     * the surface of the box
     * 
     * @return the surface of the box
     */
    public int calcSurface() {
        return _length * _width * 2 + _height * _width * 2 + _length * _height * 2;
    }

    /**
     * check if the dimensions of the box are equals to the dimensions of the given
     * box
     * 
     * @param other other box object to compare its dimensions to the current box
     *              object
     *
     * @return true / false if the dimensions are equal
     */
    public boolean equals(Box other) {
        return _length == other._length &&
                _width == other._width && _height == other._height;
    }

    public boolean bigger(Box other) {
        return this.calcVolume() > other.calcVolume() ;
    }

    public boolean smaller(Box other) {
        return other.bigger(this) ;
    }

}