public class Polygon {
    public static final int MAX_VER = 10;
    public static final int EMPTY = 0;
    private Point[] _vertices;
    private int _noOfVertices;

    public Polygon() {
        _vertices = new Point[MAX_VER];
        _noOfVertices = EMPTY;
    }

    public boolean addVertex(double x, double y) {
        if (_noOfVertices == MAX_VER)
            return false;

        _vertices[_noOfVertices++] = new Point(x, y);
        return true;
    }

    public Point highestVertex() {

        if (_noOfVertices == EMPTY)
            return null;

        Point highst = _vertices[0];
        for (int i = 0; i < _noOfVertices; i++) {
            if (_vertices[i].isAbove(highst))
                highst = _vertices[i];
        }

        return new Point(highst);
    }

    public String toString() {
        if (_noOfVertices == EMPTY)
            return "The polygon has 0 vertices.";

        String s = "The polygon has " + _noOfVertices + " vertices: \n(" + _vertices[0].toString();

        for (int i = 1; i < _noOfVertices; i++) {
            s += "," + _vertices[i].toString();
        }

        return s + ")";
    }

    public double calcPerimeter() {
        if (_noOfVertices < 2)
            return 0;

        double distance = 0;

        for (int i = 0; i < _noOfVertices - 1; i++) {
            distance += _vertices[i].distance(_vertices[i + 1]);
        }

        if (_noOfVertices > 2)
            distance += _vertices[_noOfVertices - 1].distance(_vertices[0]);

        return distance;
    }

    public double calcArea() {

        if (_noOfVertices < 3)
            return 0;

        double area = 0;

        for (int i = 0; i < _noOfVertices -2; i++) {
            area += calcTriangleArea(_vertices[0], _vertices[i+1], _vertices[i+2]);
        }

        return area;
    }

    private double calcTriangleArea(Point p1, Point p2, Point p3) {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public boolean isBigger(Polygon other) {
        return this.calcArea() > other.calcArea();
    }

    public int findVertex(Point p) {
        for (int i = 0; i < _noOfVertices; i++) {
            if (_vertices[i].equals(p))
                return i;
        }
        return -1;
    }

    public Point getNextVertex(Point p) {
        int i = findVertex(p);

        if (i == -1)
            return null;

        return new Point(_vertices[(i + 1) % _noOfVertices]);
    }

    public Polygon getBoundingBox() {

        if (_noOfVertices < 3)
            return null;

        double maxY = _vertices[0].getY();
        double minY = _vertices[0].getY();
        double maxX = _vertices[0].getX();
        double minX = _vertices[0].getX();

        double x, y;
        for (int i = 0; i < _noOfVertices; i++) {
            x = _vertices[i].getX();
            y = _vertices[i].getY();

            maxY = Math.max(maxY, y);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
        }

        Polygon square = new Polygon();
        square.addVertex(minX, minY);
        square.addVertex(maxX, minY);
        square.addVertex(maxX, maxY);
        square.addVertex(minX, maxY);
        return square;
    }
}
