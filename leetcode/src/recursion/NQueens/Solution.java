package recursion.NQueens;

// Problem : https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2804/

class Solution {
    int count=0;
    int n;
    boolean[][] puzzle;

    public int totalNQueens(int n) {
        this.n = n;
        puzzle = new boolean[n][n];

        return backtrackNQueen(0, 0);
    }

    private int backtrackNQueen(int row, int cnt){
        for(int col=0;col<n;col++){
            if(!isUnderAttack(row, col)){
                placeQueen(row, col);
                if(row + 1 == n){
                    cnt += 1;
                }else{
                    cnt = backtrackNQueen(row + 1, cnt);
                }
                removeQueen(row, col);
            }
        }
        return cnt;
    }

    private boolean isUnderAttack(int row, int col){
        for(int i=0;i<n;i++){
            // col check
            if(puzzle[i][col])
                return true;

            // upper-left
            if((row-i >= 0) && (col-i >=0) && puzzle[row-i][col-i])
                return true;
            // lower-right
            if((row+i < n) && (col+i < n) && puzzle[row+i][col+i])
                return true;
            // upper-right
            if((row-i >= 0) && (col+i < n) && puzzle[row-i][col+i])
                return true;
            // lower-left
            if((row+i < n) && (col-i >= 0) && puzzle[row+i][col-i])
                return true;

            for(int j=0;j<n;j++){
                // row check
                if(puzzle[row][j])
                    return true;
            }
        }

        return false;
    }

    private void placeQueen(int row, int col){
        puzzle[row][col] = true;
    }

    private void removeQueen(int row, int col){
        puzzle[row][col] = false;
    }

}