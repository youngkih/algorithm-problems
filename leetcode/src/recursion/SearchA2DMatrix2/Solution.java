package recursion.SearchA2DMatrix2;

// Problem: https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/
// Solution: https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66253/What-is-the-complexity-of-this-Java-solution

class Solution {
    int[][] matrix;
    int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        if(matrix.length == 0)
            return false;
        return helper(0, 0, matrix.length-1, matrix[0].length-1);
    }

    private boolean helper(int rowStart, int colStart, int rowEnd, int colEnd){
        // System.out.println("rowStart, colStart, rowEnd, colEnd: "+rowStart+", "+colStart+", "+rowEnd+", "+colEnd);
        if(rowStart > rowEnd || colStart > colEnd){
            return false;
        }

        // Pivot as the middle point
        int n = (rowEnd + rowStart)/2;
        int m = (colEnd + colStart)/2;
        boolean res = false;
        if(matrix[n][m] == target){
            return true;
        }else if(matrix[n][m] > target){
            res = (helper(rowStart, colStart, n-1, colEnd) ||
                    helper(n, colStart, rowEnd, m-1));
        }else if(matrix[n][m] < target){
            res = (helper(rowStart, m+1, rowEnd, colEnd) ||
                    helper(n+1, colStart, rowEnd, m));
        }
        return res;
    }
}