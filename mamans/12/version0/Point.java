/**
 * This class represents a Point
 */
public class Point {
    private int _x;
    private int _y;

    public static final int MIN_VALUE = 0;
    public static final int NUM_OF_FACTORS = 2;
    public static final int POWER = 2;

    // Constractors
    public Point(int x, int y) {
        if (x < MIN_VALUE)
            x = MIN_VALUE;
        if (y < MIN_VALUE)
            y = MIN_VALUE;

        _x = x;
        _y = y;
    }

    public Point(Point other) {
        _x = other._x;
        _y = other._y;
    }

    // methods

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public void setX(int num) {
        if (num >= MIN_VALUE)
            _x = num;
    }

    public void setY(int num) {
        if (num >= MIN_VALUE)
            _y = num;
    }

    public String toString() {
        return "(" + _x + "," + _y + ")";
    }

    public boolean equals(Point other) {
        return (other._x == _x && other._y == _y);
    }

    public boolean isAbove(Point other) {
        return _y > other._y;
    }

    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    public boolean isLeft(Point other) {
        return _x < other._x;
    }

    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    public void move(int deltaX, int deltaY) {
        if (_x + deltaX < MIN_VALUE || _y + deltaY < MIN_VALUE)
            return;

        _x += deltaX;
        _y += deltaY;
    }

    public Point middle(Point p) {
        return new Point((p._x + _x) / NUM_OF_FACTORS, (p._y + _y) / NUM_OF_FACTORS);
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(_x - p._x, POWER) + Math.pow(_y - p._y, POWER));
    }
}