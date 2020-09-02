// Problem: https://programmers.co.kr/learn/courses/30/lessons/60059#
import java.util.*;

class Solution {
    static int m, n;

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        m = key.length;
        n = lock.length;
        int size = n-2 + m + m;
        int[][] board = new int[size][size];

        for(int num=0;num<4;num++){
            for(int i=0;i<m+n-1;i++){
                for(int j=0;j<m+n-1;j++){
                    initializeBoard(board, key, lock);
                    updateBoard(board, key, i, j);

                    if(isUnlocked(board)){
                        return true;
                    }
                }
            }
            key = rotateKey(key);
        }

        return answer;
    }

    private int[][] rotateKey(int[][] key){
        int[][] newKey = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                newKey[i][j] = key[m-1-j][i];
            }
        }
        return newKey;
    }

    private void updateBoard(int[][] board, int[][] key, int startX, int startY){
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                board[startX+i][startY+j] += key[i][j];
            }
        }
    }

    private boolean isUnlocked(int[][] board){
        for(int i=m-1;i<m-1+n;i++){
            for(int j=m-1;j<m-1+n;j++){
                if(board[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    private void initializeBoard(int[][] board, int[][] key, int[][] lock){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j] = 0;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[m-1+i][m-1+j] = lock[i][j];
            }
        }
    }

    private void printArr(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}