package recursion.assignment;
/**
 * Implement N Queens Problem using Recursion. Placing N chess queens on an N×N chessboard so that no two queens attack each other. (Thus, a solution requires that no two queens share the same row, column, or diagonal)
 * @author tarasdranik
 *
 */
public class NQueensProblem {
    
    /**
     * Uses recursion method nQueen to solve the NQueen problem
     * @param n Integer dimension of the board
     * @return true if it is possible to solve the problem and print it, false if it is not possible to solve
     */
    public Boolean solutionNQueens(int n) { 
        int [] [] board = new int [n] [n];
        for (int i=0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board [i] [j] = 0;
            }
        }
        
        if (nQueen(board, 0) == false) { 
            return false; 
        }  
        
        printNQueensProblem(board);
        return true; 
    }
    
    /**
     * Recursion solution of Nqueen problem
     * @param board 2D Integer array which represents chess board with 0 in the nodes
     * @param startColumn Integer number of starting position to place queens.
     * @return True if it is possible to place and return changed array with 1 in the nodes where possible to place, False if it is no solution
     */
    private Boolean nQueen(int [] [] board, int startColumn){
        // If all queens are plased
        if (startColumn >= board.length) 
            return true; 
        // Check the column and try to place queens in the rows one by one
        for (int i = 0; i < board.length; i++) { 
            //If it is possibleToPlace == true place the queen (changed value of the nod to 1) on the board
            if (possibleToPlace(board, i, startColumn)) { 
                board[i][startColumn] = 1; 
                //Recursion checking the rest of the board 
                if (nQueen(board, startColumn + 1)) return true; 
                //if it is not possible, removes queen from the board
                board[i][startColumn] = 0;
            } 
        } 
        return false; 
    }
    /*
     * Check if it is possible to place Queen in the node.
     */
    private Boolean possibleToPlace(int board[][], int row, int column) { 
        int i, j; 
        
        //Check rows;
        for (i = 0; i < column; i++) if (board[row][i] == 1) return false;
        //Check upper diagonal
        for (i=row, j=column; i>=0 && j>=0; i--, j--) if (board[i][j] == 1) return false; 
        //Check lower diagonal
        for (i=row, j=column; i<board.length && j>=0; i++, j--) if (board[i][j] == 1) return false; 
        return true; 
    } 
    
    private void printNQueensProblem(int board[][]) 
    { 
        for (int i = 0; i < board.length; i++) 
        { 
            for (int j = 0; j < board.length; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 

}
