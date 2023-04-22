/**
 * This class represents 2 dimensional point. Coordinates cannot be negative.
 * 
 * @author Maya Israeli
 * @version 1.3.2023
 */

public class Point {

    // constants declaration:
    private static final int MIN_VALUE = 0; // The minimum value of x y coordinates

    // attributes declarations:
    private int _x; // x coordinate
    private int _y; // y coordinate

    // Constructors

    /**
     * Constructs a point.
     * Construct a new point with the specified x y coordinates.
     * If either coordinate is negative the coordinate will be 0.
     * 
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(int x, int y) {
        _x = x < MIN_VALUE ? MIN_VALUE : x;
        _y = y < MIN_VALUE ? MIN_VALUE : y;
    }

    /**
     * Copy constructor for Points.
     * Construct a point with the same coordinates as another point.
     * 
     * @param other The point object from which to construct the new point
     */
    public Point(Point other) {
        this(other._x, other._y); // sends the first constructor other's values
    }

    // method definitions

    // getters

    /**
     * Returns the x coordinate of the point.
     * 
     * @return The x coordiante of the point
     */
    public int getX() {
        return _x;
    }

    /**
     * Returns the y coordinate of the point.
     * 
     * @return The y coordiante of the point
     */
    public int getY() {
        return _y;
    }

    // setters

    /**
     * Changes the x coordinate of the point.
     * If a negative number is received, the x coordinate will not be changed.
     * 
     * @param num The new x coordinate
     */
    public void setX(int num) {
        if (num >= MIN_VALUE)
            _x = num;
    }

    /**
     * Changes the y coordinate of the point.
     * If a negative number is received, the y coordinate will not be changed.
     * 
     * @param num The new y coordinate
     */
    public void setY(int num) {
        if (num >= MIN_VALUE)
            _y = num;
    }

    /**
     * Return a string representation of this point.
     * 
     * @return String representation of this point
     */
    public String toString() {
        return "(" + _x + "," + _y + ")";
    }

    /**
     * Check if the received point is equal to this point.
     * 
     * @param other The point to be compared with this point
     * @return true if the received point is equal to this point
     */
    public boolean equals(Point other) {
        return other._x == _x && other._y == _y;
    }

    /**
     * Check if this point is above a received point.
     * 
     * @param other The point to check if this point is above
     * @return true if this point is above other point
     */
    public boolean isAbove(Point other) {
        return _y > other._y;
    }

    /**
     * Check if this point is below a received point.
     * 
     * @param other The point to check if this point is below
     * @return true if this point is below other point
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    /**
     * Check if this point is left of a received point.
     * 
     * @param other The point to check if this point is left of
     * @return true if this point is left of other point
     */
    public boolean isLeft(Point other) {
        return _x < other._x;
    }

    /**
     * Check if this point is right of a received point.
     * 
     * @param other The point to check if this point is right of
     * @return true if this point is right of other point
     */
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    /**
     * Move the x coordinate deltaX and the y coordinate deltaY.
     * If the new coordinates are not in the first quadrant the point should not be
     * moved.
     * 
     * @param deltaX The amount to move x
     * @param deltaY - The amount to move y
     */
    public void move(int deltaX, int deltaY) {

        if (_x + deltaX >= MIN_VALUE && _y + deltaY >= MIN_VALUE) {
            // the new coordinates are in the first quadrant
            _x += deltaX;
            _y += deltaY;
        }
    }

    /**
     * Return a new point in between this point and the received point.
     * 
     * @param p the received point
     * @return new Point in between this point and the received point
     */
    public Point middle(Point p) {
        final int NUM_OF_FACTORS = 2; // The number of factors in the calculation of the average
        return new Point((p._x + _x) / NUM_OF_FACTORS, (p._y + _y) / NUM_OF_FACTORS);
    }

    /**
     * Check the distance between this point and a received point.
     * 
     * @param p The point to check distance from
     * @return double representing the distance
     */
    public double distance(Point p) {
        final int POWER = 2; // A number is raise to the power of 2
        return Math.sqrt(Math.pow(_x - p._x, POWER) + Math.pow(_y - p._y, POWER));
    }

} // class point