/**
 * This class represents a Date object
 * 
 * @author Maya Israeli
 * @version 1.3.2023
 */

public class Date {

    // constants declaration:
    public static final int DEFULT_DAY = 1;
    public static final int DEFULT_MONTH = 1;
    public static final int DEFULT_YEAR = 2000;

    // attributes declarations:
    private int _day;
    private int _month;
    private int _year;

    // Constractors

    /**
     * Constructs a date object.
     * If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
     * @param day the day in the month (1-31)
     * @param month the month in the year (1-12)
     * @param year the year (4 digits)
     */   
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

    /**
     * Copy constructor for dates
     * Construct a new date with the same attributes as other date.
     * @param other - the date to be copied
     */  
    public Date(Date other) {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    // method definitions

        //getters

    /** 
     * Gets the day
     * @return the day
     */
    public int getDay() {
        return _day;
    }

    /** 
     * Gets the month
     * @return the month
     */
    public int getMonth() {
        return _month;
    }

    /** 
     * Gets the year
     * @return the year
     */
    public int getYear() {
        return _year;
    }

        //setters
    /** 
     * Set the day (only if date remains valid)
     * @param dayToSet the day value to be set
     */    
    public void setDay(int dayToSet) {
        if (isValidDate(dayToSet, _month, _year))
            _day = dayToSet;
    }

    /** 
     * Set the month (only if date remains valid)
     * @param monthToSet the month value to be set
     */ 
    public void setMonth(int monthToSet) {
        if (isValidDate(_day, monthToSet, _year))
            _month = monthToSet;
    }

    /** 
     * Sets the year (only if date remains valid)
     * @param yearToSet the year value to be set
     */ 
    public void setYear(int yearToSet) {
        if (isValidDate(_day, _month, yearToSet))
            _year = yearToSet;
    }

    /** 
     * Check if two dates are the same
     * @param other the date to compare this date to
     * @return true if the dates are the same
     */
    public boolean equals(Date other) {
        return other._day == _day && other._month == _month && other._year == _year;
    }

    /** 
     * Check if this date is before other date
     * @param other date to compare this date to
     * @return true if this date is before other date
     */
    public boolean before(Date other) {
        return calculateDate(_day, _month, _year) < calculateDate(other._day, other._month, other._year);
    }

    /** 
     * Check if this date is after  other date
     * @param other date to compare this date to
     * @return true if this date is after other date
     */
    public boolean after(Date other) {
        return other.before(this);
    }

    /** 
     * Calculates the difference in days between this date and other date
     * @param other the date to calculate the difference between
     * @return the number of days between the dates (non negative value)
     */
    public int difference(Date other) {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    }

    /** 
     * Calculate the date of tomorrow
     * @return the date of tomorrow
     */
    public Date tomorrow() {
        if (isValidDate(_day + 1, _month, _year))
            return new Date(_day + 1, _month, _year);
        else if (isValidDate(1, _month + 1, _year))
            return new Date(1, _month + 1, _year);

        return new Date(1, 1, _year + 1);
    }

    /** 
     * Returns a String that represents this date
     * @return String that represents this date in the following format:
     * day (2 digits) / month(2 digits) / year (4 digits)
     * for example: 02/03/1998
     */
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

    // Creceives three integers representing day, month and year,
    // checks whether the date represented by these numbers  is a valid date in the Gregorian Calendar.
    private boolean isValidDate(int day, int month, int year) {

        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1000 || year > 9999)
            return false;
        else if ((day == 29 || day == 30) && month == 2)
            return false;
        else if (day == 31 && (month == 2 || month == 4 || month == 6 || month == 9 || month == 11))
            return false;

        return true;
    }

    // Creceives three integers representing day, month and year,
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
