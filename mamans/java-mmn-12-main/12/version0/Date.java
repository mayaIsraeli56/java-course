public class Date {
    private int _day;
    private int _month;
    private int _year;

    public static final int DEFULT_DAY = 1;
    public static final int DEFULT_MONTH = 1;
    public static final int DEFULT_YEAR = 2000;

    // Constractors
    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            _day = day;
            _month = month;
            _year = year;
        } else {
            _day = DEFULT_DAY;
            _month = DEFULT_MONTH;
            _year = DEFULT_YEAR;
        }
    }

    public Date(Date other) {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    // methods

    public int getDay() {
        return _day;
    }

    public int getMonth() {
        return _month;
    }

    public int getYear() {
        return _year;
    }

    public void setDay(int dayToSet) {
        if (isValidDate(dayToSet, _month, _year))
            _day = dayToSet;
    }

    public void setMonth(int monthToSet) {
        if (isValidDate(_day, monthToSet, _year))
            _month = monthToSet;
    }

    public void setYear(int yearToSet) {
        if (isValidDate(_day, _month, yearToSet))
            _year = yearToSet;
    }

    public boolean equals(Date other) {
        return other._day == _day && other._month == _month && other._year == _year;
    }

    public boolean before(Date other) {
        return calculateDate(_day, _month, _year) < calculateDate(other._day, other._month, other._year);
    }

    public boolean after(Date other) {
        return other.before(this);
    }

    public int difference(Date other) {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    }

    public Date tomorrow() {
        if (isValidDate(_day + 1, _month, _year))
            return new Date(_day + 1, _month, _year);
        else if (isValidDate(1, _month + 1, _year))
            return new Date(1, _month + 1, _year);

        return new Date(1, 1, _year + 1);
    }

    public String toString() {
        String day, month;

        if (_day < 10)
            day = "0" + _day;
        else
            day = Integer.toString(_day);

        if (_month < 10)
            month = "0" + _month;
        else
            month = Integer.toString(_month);

        return day + "/" + month + "/" + _year;
    }

    private boolean isValidDate(int day, int month, int year) {

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1000 || year > 9999)
            return false;
        else if ((day == 29 || day == 30) && month == 2)
            return false;
        else if (day == 31 && (month == 2 || month == 4 || month == 6 || month == 9 || month == 11))
            return false;

        return true;
    }

    // computes the day number since the beginning of the Christian counting of
    // years
    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }
}
