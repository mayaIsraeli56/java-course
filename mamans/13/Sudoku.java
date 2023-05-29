/**
 * Sudoku - a game you need to fill digits 1 to 9 in a board 9x9.
 *
 * @version 12/2021
 */

public class Sudoku
{
    //Constant declration
    private static final int BOARD_ROWS = 3;
    private static final int BOARD_COLS = 3;
    private static final int FIRST_NUM = 1;
    private static final int LAST_NUM = BOARD_ROWS * BOARD_COLS;
    private static final int DIGITS_ARRAY_SIZE = LAST_NUM + 1;
    
    //Attributes declration
    private Square3x3[][] _sudokuBoard;
    
    
    //Constructors
    /**
    * Creates a 2D Square3x3 array and initial it with default value -1.
    */
    public Sudoku()
    {
        _sudokuBoard = new Square3x3[BOARD_ROWS][BOARD_COLS];
        
        for(int i=0; i<BOARD_ROWS; i++)
            for(int j=0; j<BOARD_COLS; j++)
                _sudokuBoard[i][j] = new Square3x3();
    }
    
    
    /**
    * Create a 2D Square3x3 array and copy the values from other sudokuboard.
    * 
    * @param square3x3Array  A sudoku board
    */
    public Sudoku(Square3x3[][] square3x3Array)
    {
        //Initial the board with the default constructur
        this();
         
        for(int i=0; i<BOARD_ROWS; i++)
            for(int j=0; j<BOARD_COLS; j++)
                _sudokuBoard[i][j] = new Square3x3(square3x3Array[i][j]);
    }
    
    
    
    //Public Methods
    /**
     * Check if the board is validate.
     * 
     * @return  True if the board is validate, otherwise false.
     * 
     */
    public boolean isValid()
    {
        //check if each square, each row and each column contain all the digits. 
        if (this.isAllThereInBoard() && this.allBoardRowsCheck() && this.allBoardColsCheck())
            return true;
        return false;
    }
    
    
    //Private Methods
    private boolean isAllInArray(boolean[] digitsArray)
    /*
     * Check if the array contain all the numbers
     * Start checking from index 1.
     * Return true if yes, otherwish false.
     */
    {
        for(int i=1; i<digitsArray.length; i++)
            if(!(digitsArray[i]))
                return false;
        return true;
    }
    
    
    private boolean isAllThereInBoard()
    /*
     * Check if each cell(square3x3) contain all the digits inside.
     * Return true if yes, otherwish false. 
     */
    {
        boolean isAllThere = true;
        
        //check each cell if it contain all the digits. if one cell isn't contain, return false.
        for(int i=0; i<BOARD_ROWS && isAllThere; i++)
            for(int j=0; j<BOARD_COLS && isAllThere; j++)
                if( !(_sudokuBoard[i][j].allThere()) )
                    isAllThere = false;
        return isAllThere;
    }
    
    
    private boolean isAllInRow(int rowNum)
    /*
     * Getting a row number and check if all the digits appear in the row
     * Return true if all the digits apear in the row, otherwish return false.
     */
    {
        int rowInBoard;                                         //The row of the board
        int rowInSquare;                                        //The row in the sqaure3x3
        boolean[] digitsArr = new boolean[DIGITS_ARRAY_SIZE];   //A boolean array for digit check
        
        rowInBoard = (rowNum-1)/BOARD_ROWS;     //calculate the row in the board from the rowNum
        rowInSquare = (rowNum-1)%BOARD_ROWS;    //calculate the row in the square3x3 from the rowNum
        
        //Check the row of square3x3 at row position 'rowInSqaure', in each sqaures in the board at row position 'rowInBoard'
        for(int i=0; i<BOARD_COLS; i++)
            _sudokuBoard[rowInBoard][i].whosThereRow(rowInSquare, digitsArr);
        
        return this.isAllInArray(digitsArr);
    }
    
    
    private boolean allBoardRowsCheck()
    /*
     * Check if each row in the board contain all the digits
     * Return True if yes, otherwise return false.
     */
    {
        for(int i=FIRST_NUM; i<=LAST_NUM; i++)
            if( !(isAllInRow(i)) )
                return false;
        return true;
    }
    
    
    private boolean isAllInCol(int colNum)
    /*
     * Getting a col number and check if all the digits appear in the col
     * return true if all the digits apear in the row, otherwish return false. 
     */
    {
        int colInBoard;                                         //The col of the board
        int colInSquare;                                        //The col in the sqaure3x3
        boolean[] digitsArr = new boolean[DIGITS_ARRAY_SIZE];   //A boolean array for digit check
        
        colInBoard = (colNum-1)/BOARD_COLS;     //calculate the col in the board from the colNum
        colInSquare = (colNum-1)%BOARD_COLS;    //calculate the col in the square3x3 from the colNum
        
        //Check the col of square3x3 at col position 'colInSqaure', in each sqaures in the board at col position 'colInBoard'
        for(int i=0; i<BOARD_COLS; i++)
            _sudokuBoard[i][colInBoard].whosThereCol(colInSquare, digitsArr);
        
        return this.isAllInArray(digitsArr);
    }
    
    
    private boolean allBoardColsCheck()
    /*
     * Check if each col in the coard contain all the digits
     * Return True if yes, otherwise return false.
     */
    {
        for(int i=1; i<=LAST_NUM; i++)
            if( !(isAllInCol(i)) )
                return false;
        return true;
    }

}//End of class