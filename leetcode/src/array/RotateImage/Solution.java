package array.RotateImage;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp;

        // Swap up side down
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = tmp;
            }
        }

        // Swap diagonal
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}