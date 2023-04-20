package Food;

public class Pizza extends Food {
    int _numOfTops;
    int _numOfSlices;

    private final int DEF_TOPS = 1;
    private final int DEF_SLICES = 8;

    public Pizza() {
        super();
        _numOfTops = DEF_TOPS;
        _numOfSlices = DEF_SLICES;
    }

    public Pizza(int numOfTops, int numOfSlices, int cal, String lastDate) {
        super(cal, lastDate);
        _numOfTops = numOfTops;
        _numOfSlices = numOfSlices;
    }

    public int getNumOfTops() {
        return _numOfTops;
    }

    public int getNumOfSlices() {
        return _numOfSlices;
    }

    public void setNumOfTops(int numOfTops) {
        _numOfTops = numOfTops;
    }

    public void setNumOfSlices(int numOfSlices) {
        _numOfSlices = numOfSlices;
    }

    public void eat() {
        System.out.println("I'm eating pizza!!!");
    }

    public String toString() {
        return "Tops: " + _numOfTops + ", Slices: " + _numOfSlices + ", " + super.toString();
    }
}
