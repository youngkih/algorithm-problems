package SetMatrixZeroes;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/777/
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        ArrayList<Integer> rowList = new ArrayList<>();
        ArrayList<Integer> colList = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    if(!rowList.contains(i)){
                        rowList.add(i);
                    }
                    if(!colList.contains(j)){
                        colList.add(j);
                    }
                }
            }
        }

        for(int i=0;i<rowList.size();i++){
            int row = rowList.get(i);
            for(int j=0;j<m;j++){
                matrix[row][j] = 0;
            }
        }
        for(int i=0;i<colList.size();i++){
            int col = colList.get(i);
            for(int j=0;j<n;j++){
                matrix[j][col] = 0;
            }
        }
    }
}