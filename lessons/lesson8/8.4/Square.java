public class Square extends Shape{

    double _size;

    public Square(String color, boolean isVisible, Point origin, double size) {
        super(color, isVisible, origin);
        _size = size;

    }

     public String toString() {
        return super.toString() + " size: " + _size;
    }

    public void draw() {}
}