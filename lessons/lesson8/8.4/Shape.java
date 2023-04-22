public abstract class Shape {
    String _color;
    boolean _isVisible;
    Point _origin;

    public Shape(String color, boolean isVisible, Point origin) {
        _color = color;
        _isVisible = isVisible;
        _origin = origin;
    }

    public void makeVisible() {
    }

    public void makeInVisible() {
    }

    public void moveHorizontal(double x) {
        _origin.move(x, 0);
    }

    public void moveVertical(double y) {
        _origin.move(0, y);
    }

    public void move(double x, double y) {
        _origin.move(x, y);
    }

    public String toString() {
        return "color: " + _color + " isVisible: " + _isVisible + " origin: " + _origin.toString();
    }

    public abstract void draw();
}