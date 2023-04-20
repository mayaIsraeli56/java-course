package Food;

public class Food {
    private int _cal;
    private String _lastDate;

    private static final int DEF_CAL = 100;
    private static final String DEF_LAST_DATE = "1/1/1900";

    public Food() {
        this(DEF_CAL, DEF_LAST_DATE);
    }

    public Food(int cal, String lastDate) {
        _cal = cal;
        _lastDate = lastDate;
    }

    public int getCal() {
        return _cal;
    }

    public String getLastDate() {
        return _lastDate;
    }

    public void setCal(int cal) {
        _cal = cal;
    }

    public void setLastDate(String lastDate) {
        _lastDate = lastDate;
    }

    public void eat() {
       System.out.println("I'm eating food");
    }

    public String toString() {
        return "Cal: " + _cal + ", Last Date: " + _lastDate;
    }

}