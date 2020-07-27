package Triangle;

// Problem: https://leetcode.com/problems/triangle/

/*
 - Leetcode Solution( https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle/239481 )
 - O(N) Space
 - Summing up from top to bottom equals the opposite. This solution starts from bottom
 - * Idea: Initialize DP array with the existing triangle's bottom
*/
// class Solution{
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int size = triangle.size();
//         int[] dp = new int[size];

//         // Initialize DP array with the bottom of triangle
//         for(int i=0;i<size;i++){
//             dp[i] = triangle.get(size - 1).get(i);
//         }

//         // Bottom-up.
//         for(int i=size-2;i>=0;i--){
//             List<Integer> curList = triangle.get(i);

//             for(int j=0;j<=i;j++){
//                 dp[j] = Math.min(dp[j], dp[j+1]) + curList.get(j);
//             }
//         }
//         return dp[0];
//     }
// }


// My Solution using DP - bottom-up. O(N^2) Space
// class Solution {
//     int min = Integer.MAX_VALUE;
//     List<List<Integer>> triangle;
//     int[][] dp;
//     boolean[][] checked;

//     public int minimumTotal(List<List<Integer>> triangle) {
//         this.triangle = triangle;
//         int size = triangle.size();

//         if(size == 0){
//             return 0;
//         }

//         dp = new int[size][size];
//         checked = new boolean[size][size];

//         for(int i=0;i<size;i++){
//             int row = size-1;
//             int col = i;
//             min = Math.min(min, getMinSum(row, col));
//         }
//         return min;
//     }

//     private int getMinSum(int row, int col){
//         if(checked[row][col]){
//             return dp[row][col];
//         }

//         if(row == 0){
//             dp[0][0] = triangle.get(0).get(0);
//             checked[0][0] = true;

//             return dp[0][0];
//         }
//         if(col == 0){
//             int minSum = getMinSum(row-1, 0) + triangle.get(row).get(0);
//             dp[row][0] = minSum;
//             checked[row][0] = true;

//             return dp[row][0];
//         }
//         if(col == row){
//             int minSum = getMinSum(row-1, col-1) + triangle.get(row).get(col);
//             dp[row][col] = minSum;
//             checked[row][col] = true;

//             return dp[row][col];
//         }


//         int min = Math.min(getMinSum(row-1, col-1), getMinSum(row-1, col)) + triangle.get(row).get(col);
//         dp[row][col] = min;
//         checked[row][col] = true;

//         return min;
//     }
// }