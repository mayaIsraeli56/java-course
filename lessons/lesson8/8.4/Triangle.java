public class Triangle extends Shape{

    double _height;
   double _width;

    public Triangle(String color, boolean isVisible, Point origin, double height, double width) {
        super(color, isVisible, origin);
        _height = height;
        _width =width;
    }

     public String toString() {
        return super.toString() + " height: " + _height + " wisth: " + _width;
    }

    public void draw() {}
}