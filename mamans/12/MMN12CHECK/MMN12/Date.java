/*#Shadi:
 * grade 29/30
 */
/**
 * This class represents a Date object
 * 
 * @author Maya Israeli
 * @version 1.3.2023
 */
/*#Shadi:-1
 * 1- 31 should be defined as final
 */
public class Date {

    // attributes declarations:
    private int _day;
    private int _month;
    private int _year;

    // Constructors

    /**
     * Constructs a date object.
     * If the given date is valid - creates a new Date object,
     * otherwise creates the date 1/1/2000
     * 
     * @param day   the day in the month (1-31)
     * @param month the month in the year (1-12)
     * @param year  the year (4 digits)
     */
    public Date(int day, int month, int year) {

        // constants declaration:
        final int DEFULT_DAY = 1;
        final int DEFULT_MONTH = 1;
        final int DEFULT_YEAR = 2000;

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
     * 
     * @param other - the date to be copied
     */

    public Date(Date other) {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    // method definitions

    // getters

    /**
     * Gets the day
     * 
     * @return the day
     */
    public int getDay() {
        return _day;
    }

    /**
     * Gets the month
     * 
     * @return the month
     */
    public int getMonth() {
        return _month;
    }

    /**
     * Gets the year
     * 
     * @return the year
     */
    public int getYear() {
        return _year;
    }

    // setters

    /**
     * Set the day (only if date remains valid)
     * 
     * @param dayToSet the day value to be set
     */
    public void setDay(int dayToSet) {
        if (isValidDate(dayToSet, _month, _year))
            _day = dayToSet;
    }

    /**
     * Set the month (only if date remains valid)
     * 
     * @param monthToSet the month value to be set
     */
    public void setMonth(int monthToSet) {
        if (isValidDate(_day, monthToSet, _year))
            _month = monthToSet;
    }

    /**
     * Sets the year (only if date remains valid)
     * 
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet) {
        if (isValidDate(_day, _month, yearToSet))
            _year = yearToSet;
    }

    /**
     * Check if two dates are the same
     * 
     * @param other the date to compare this date to
     * @return true if the dates are the same
     */
    public boolean equals(Date other) {
        return other._day == _day && other._month == _month && other._year == _year;
    }

    /**
     * Check if this date is before other date
     * 
     * @param other date to compare this date to
     * @return true if this date is before other date
     */
    public boolean before(Date other) {
        // If fewer days have passed since the beginning of the counting -
        // the date comes first.
        return calculateDate(_day, _month, _year) < calculateDate(other._day, other._month, other._year);
    }

    /**
     * Check if this date is after other date
     * 
     * @param other date to compare this date to
     * @return true if this date is after other date
     */
    public boolean after(Date other) {
        return other.before(this);
    }

    /**
     * Calculates the difference in days between this date and other date
     * 
     * @param other the date to calculate the difference between
     * @return the number of days between the dates (non negative value)
     */
    public int difference(Date other) {
        // calculates the difference between dates using the calculateDate method
        // returns the absolute value of the diffrence
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    }

    /**
     * Returns a String that represents this date
     * 
     * @return String that represents this date in the following format:
     *         day (2 digits) / month(2 digits) / year (4 digits)
     *         for example: 02/03/1998
     */
    public String toString() {

        // constants declaration:
        final int MIN_2_DIGIT_NUM = 10;
        final String PREFIX = "0";
        final String NO_PREFIX = "";

        String day = _day < MIN_2_DIGIT_NUM ? PREFIX + _day : NO_PREFIX + _day;
        String month = _month < MIN_2_DIGIT_NUM ? PREFIX + _month : NO_PREFIX + _month;

        return day + "/" + month + "/" + _year;
    }

    /**
     * Calculate the date of tomorrow
     * 
     * @return the date of tomorrow
     */
    public Date tomorrow() {

        final int PROMOTION = 1; // Used to increase the counters of the days, months, and years

        // Checks whether only the day should be promoted
        if (isValidDate(_day + PROMOTION, _month, _year))
            return new Date(_day + PROMOTION, _month, _year);

        // else checks whether only the day and the month should be promoted
        if (isValidDate(PROMOTION, _month + PROMOTION, _year))
            return new Date(PROMOTION, _month + PROMOTION, _year);

        // else promotes the day, the month and the year
        return new Date(PROMOTION, PROMOTION, _year + PROMOTION);
    }

    /**
     * @param day
     * @param month
     * @param year
     * @return boolean
     */
    /*
     * Receives three integers representing day, month and year,
     * checks whether the date represented by these numbers is a valid date in the
     * Gregorian Calendar.
     */
    private boolean isValidDate(int day, int month, int year) {

        // constants declaration:
        final int FIRST_DAY = 1; // The number of the first day of the month
        final int LAST_DAY = 31; // The number of the last possible day of the month
        final int FIRST_MONTH = 1;
        final int LAST_MONTH = 12;

        // Year must have four digits
        final int MIN_YEAR = 1000; // the minimum year that meets the requirement
        final int MAX_YEAR = 9999; // the maximum year that meets the requirement

        final int DAYS_IN_FEB = 28; // The number of days in February
        final int FEB = 2; // The serial number of February
        final int APR = 4; // The serial number of Aprile
        final int JUN = 6; // The serial number of June
        final int SEP = 9; // The serial number of September
        final int NOV = 11; // The serial number of November

        // Are params possible - day(1-31), month(1-12), year(4 digits)
        if (day < FIRST_DAY || day > LAST_DAY || month < FIRST_MONTH ||
                month > LAST_MONTH || year < MIN_YEAR || year > MAX_YEAR)
            return false;

        // February has only 28 days
        if (month == FEB && day > DAYS_IN_FEB)
            return false;

        // Apr, Jun, Sep, and Nov have only 30 days
        if (day == LAST_DAY && (month == APR ||
                month == JUN || month == SEP || month == NOV))
            return false;

        // The date is valid
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

} // class Date
