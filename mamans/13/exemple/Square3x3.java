/**
 * Square3x3 - Represent an 2d array 3x3 that contain a integer.
 * 
 * 
 * @version: 12/2021
 */

public class Square3x3
{
    //Constants
    private static final int SQUARE_ROWS = 3;                          //The number of square rows
    private static final int SQUARE_COLUMNS = 3;                       //The number of sqaure columns 
    private static final int DEFAULT_VALUE = -1;                       //The default value for initial the square
    private static final int FIRST_NUM = 1;                            //The first valid number
    private static final int LAST_NUM = SQUARE_ROWS * SQUARE_COLUMNS;  //The Last valid number
    private static final int DIGITS_ARRAY_SIZE = LAST_NUM + 1;         //Used to define the array size.
    
    //Attributes
    private int[][] _square;
    
    
    //constructurs
    /**
     * Create a 2D integer array, inital with default value
     */
    public Square3x3()
    {
        _square = new int[SQUARE_ROWS][SQUARE_COLUMNS];
        
        for (int i=0; i<SQUARE_ROWS; i++)
            for(int j=0; j<SQUARE_COLUMNS; j++)
                _square[i][j] = DEFAULT_VALUE;
    }
        
    /**
     * Create a 2D integer array, whose values are taken from the given array. Inital "empty" cells with default value.
     * 
     * @param array   An integer array
     * 
     */

    public Square3x3(int[][] array)
    {
        //Initial the board with the default constructur
        this();
        
        //Replace the valuses from the given array
        for(int i=0; i<SQUARE_ROWS && i<array.length; i++)
            for(int j=0; j<SQUARE_COLUMNS && j<array[i].length; j++)
                this._square[i][j] = array[i][j];
    }
    
    
    /**
     * Create a 2D integer array, whose values are taken from other Square3x3 object.
     * 
     * @param other   A Square3x3 object
     * 
     */
    public Square3x3(Square3x3 other)
    {
        //Initial the board with the default constructur
        this();
        
        for (int i=0; i<SQUARE_ROWS; i++)
            for(int j=0; j<SQUARE_COLUMNS; j++)
                this._square[i][j] = other._square[i][j];
    }
    
    
    //toString Method
    /**
     * Representation of the object in String
     *  
     * @return  the cell values in table.
     * 
     */
    public String toString()
    {
        String msg = "";
        
        for(int i=0; i < SQUARE_ROWS; i++)
        {            
            for(int j=0; j < SQUARE_COLUMNS; j++)
            {
                msg += _square[i][j];
                
                if( j != SQUARE_COLUMNS-1)
                    msg += "\t";
            }
            //add new line at the end of the row
            msg += "\n";
        }
        
        return msg;
    }
    
    
    //Methods
    /**
     * Returns the value of the cell. If the row and/or col are out of the array bounds, returns –1.
     * 
     * @param  row   The row number
     * @param  col   The col number
     * 
     * @return  The value of the cell. -1 for outbound cell.
     * 
     */    
    public int getCell(int row, int col)
    {
        //Checking if the row and col are out of the bounds. 
        //If yes, return -1, otherwise it will return the cell value. 
        if( (row >= SQUARE_ROWS || row < 0) ||  
            (col >= SQUARE_COLUMNS || col < 0) )
                return -1;
        return _square[row][col];
    }
    
    
    /**
     * Set the value of the cell. If the row and/or col are out of the array bounds, does nothing.
     * 
     * @param  row      Row number
     * @param  col      Col number
     * @param  value    A new value of the cell
     * 
     */
    public void setXY(int row, int col, int value)
    {
        //Checking if the row and col in the bounds, if yes, set the new value in the cell.
        if( (row < SQUARE_ROWS && row >= 0) &&
            (col < SQUARE_COLUMNS && col >= 0) )
                _square[row][col] = value;    
    }
    
    
    /**
     * Check if all the digits appear in the array
     * 
     * @return  True if all the digits appear in the square.
     * 
     */
    
    public boolean allThere()
    {
        //A boolean array to check if all the numbers appear in the sqaure
        boolean[] digitArr = new boolean[DIGITS_ARRAY_SIZE];
        for(int i=0; i<SQUARE_ROWS; i++)
            for(int j=0; j<SQUARE_COLUMNS; j++)
                //Check if the cell value is valid number and if there is no duplicate number 
                if(_square[i][j]<FIRST_NUM || _square[i][j]>LAST_NUM || digitArr[_square[i][j]]==true)
                    return false;
                else
                    digitArr[_square[i][j]]=true;
        return true;
    }
    
    
    /**
     * Check the row in the square and set true in the array at the digit location.
     * If the cell is not valid, does nothing.
     * 
     * @param  row      A row in the square.
     * @param  values   A boolean array for digits check.
     * 
     */
    public void whosThereRow (int row, boolean[] values)
    {
        //check if the row is valid num
        if(row >= 0 && row < SQUARE_ROWS)
            for(int i=0; i<SQUARE_COLUMNS; i++)
                //check if the cell's value is valid
                if ( _square[row][i] >= FIRST_NUM &&
                     _square[row][i] <= LAST_NUM )
                    values[_square[row][i]] = true;
    }
    
    
    /**
     * Check the col in the square and set true in the array at the digit location.
     * If the cell is not valid, does nothing.
     * 
     * @param  col      A col in the square.
     * @param  values   A boolean array for digits check.
     * 
     */
    public void whosThereCol (int col, boolean[] values)
    {
        //check if the col is valid num
        if(col >= 0 && col < SQUARE_COLUMNS)
            for(int i=0; i<SQUARE_ROWS; i++)
                //check if the cell's value is valid
                if ( _square[i][col] >= FIRST_NUM &&
                     _square[i][col] <= LAST_NUM )
                    values[_square[i][col]] = true;
    }
    
}//End of class
