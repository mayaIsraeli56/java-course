public class Circle extends Shape{

    double _diameter;

    public Circle(String color, boolean isVisible, Point origin, double diameter) {
        super(color, isVisible, origin);
        _diameter = diameter;

    }

    public void expand(double expandBy) {
        _diameter *= expandBy;
     }

     public String toString() {
        return super.toString() + " diameter: " + _diameter;
    }

    public void draw() {}
}