package recursion.SudokuSolver;

// Problem: https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2796/
// Solution: https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2796/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking

class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col] == '.'){
                    for(char val = '1'; val <= '9'; val++){
                        if(isValid(board, row, col, val)){
                            board[row][col] = val;

                            if(backtrack(board)){
                                return true;
                            }else{
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char val){
        for(int i=0;i<9;i++){
            // check col
            if(board[row][i] == val)
                return false;
            // check row
            if(board[i][col] == val)
                return false;
        }

        // check grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j] == val)
                    return false;
            }
        }
        return true;
    }
}