package array.ValidSudoku;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/

class Solution {
    int n, m;

    public boolean isValidSudoku(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;

        return checkRow(board) && checkCol(board) && checkBox(board);
    }

    private boolean checkRow(char[][] board){
        boolean[] isChecked;

        for(int i=0;i<n;i++){
            isChecked = new boolean[10];
            for(int j=0;j<m;j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(isChecked[num]){
                        return false;
                    }else{
                        isChecked[num] = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board){
        boolean[] isChecked;

        for(int j=0;j<m;j++){
            isChecked = new boolean[10];
            for(int i=0;i<n;i++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(isChecked[num]){
                        return false;
                    }else{
                        isChecked[num] = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkBox(char[][] board){
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                if(!checkMyBox(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkMyBox(char[][] board, int x, int y){
        boolean[] isChecked = new boolean[10];

        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(isChecked[num]){
                        return false;
                    }else{
                        isChecked[num] = true;
                    }
                }
            }
        }
        return true;
    }
}