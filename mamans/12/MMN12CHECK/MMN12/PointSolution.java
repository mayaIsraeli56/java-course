/**
 * Represents 2 dimensional point.
 * Coordinates cannot be negative.
 * 
 */
public class PointSolution
{
    //instance variables
    private int _x;
    private int _y;
    public final int MIN_COORDINATE=0;

    /**
     * Constructs a point.
     * Construct a new point with the specified x y coordinates.
     * If either coordinate is negative the coordinate will be 0.
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public PointSolution(int x, int y) 
    {
        _x =x>MIN_COORDINATE? x:MIN_COORDINATE;
        _y = y>MIN_COORDINATE?y:MIN_COORDINATE;

    }

    /**
     * Copy constructor for Points.
     * Construct a point with the same coordinates as  another point.
     * @param other The point object from  which to construct the new point
     */
    public PointSolution(PointSolution other)
    {
        _x = other._x;
        _y = other._y;
    }

    /**
     * Returns the x coordinate of the point.
     * @return The x coordiante of the point
     */
    public int getX()
    {
        return _x;
    }

    /**
     * Returns the y coordinate of the point.
     * @return The y coordinate of the point
     */
    public int getY()
    {
        return _y;
    }

    /**
     * Changes the x coordinate of the point.
     * If a negative number is received x will be set to  0.
     * @param x The new x coordinate
     */
    public void setX (int x)
    {
        if (x >= MIN_COORDINATE) 
            _x = x;
    }

    /**
     * Changes the y coordinate of the point.
     * If a negative number is received y will be set to 0.
     * @param y The new y coordinate
     */
    public void setY (int y)
    {
        if (y >= MIN_COORDINATE) 
            _y = y;
    }

    /**
     * Check if the received point is equal to this point.
     * @param other The point to be compared with this point
     * @return True if the received point is  equal to this point
     */
    public boolean equals(PointSolution other)
    {
        return (_x == other._x && _y == other._y);
    }

    /**
     * Check if this point is  above a received  point.
     * @param other The point to check if this point is above
     * @return True if this point is above other point
     */
    public boolean isAbove(PointSolution other)
    {
        return (_y > other._y);
    }

    /**
     * Check if this point is  below a received  point.
     * @param other The point to check if this point is below
     * @return True if this point is below other point
     */
    public boolean isUnder(PointSolution other)
    {
        return other.isAbove(this);
    }

    /**
     * Check if this point is  left of  a received  point.
     * @param other The point to check if this point is left of
     * @return True if this point is left of  other point
     */
    public boolean isLeft(PointSolution other)
    {
        return ( _x < other._x);
    }

    /**
     * Check if this point is  right of  a received  point.
     * @param other The point to check if this point is right of
     * @return True if this point is right of  other point
     */
    public boolean isRight(PointSolution other)
    {
        return other.isLeft(this);
    }

    /**
     * Check the distance between this point and a received point.
     * @param other The point to check distance from
     * @return double representing the distance
     */
    public double distance(PointSolution other)
    {
        return Math.sqrt(Math.pow((other._y -_y), 2) + Math.pow((other._x - _x), 2));
    }    

    /**
     * Move the x  coordinate dX and the y coordinate dY. 
     * If the new coordinates are negative they will be set to 0.
     * @param dX The amount to move x
     * @param dY The amount to move y
     */
    public void move(int dX, int dY)
    {
        if(_x + dX>=MIN_COORDINATE && _y + dY>=MIN_COORDINATE)
        {
            setX(_x + dX);
            setY(_y + dY);
        }
    }    

    /**
     * Return a new point in between this point and the received point.
     * @param other a the received point
     * @return new Point in between this point and the received point
     */
    public PointSolution middle(PointSolution other)
    {
        return new PointSolution((_x + other._x)/2,(_y + other._y)/2);
    }       

    /**
     * Return a string representation of this point.
     * @return String representation of this point
     */
    public String toString()
    {
        return( "(" + _x + "," + _y + ")" );
    }

}
