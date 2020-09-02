package UniquePaths;

/*
 - Leetcode Solution using DP - O(N) Space, O(NM) Time
 - https://leetcode.com/problems/unique-paths/discuss/22953/Java-DP-solution-with-complexity-O(n*m)/22365
 - * Idea: Initialize DP array with the first column/row of the table. And then manipulate in-place
*/
class Solution {
    int[] dp;

    public int uniquePaths(int m, int n){
        dp = new int[n];

        if(m == 0 || n == 0)
            return 0;
        if(m == 1 || n ==1)
            return 1;

        for(int i=0;i<n;i++){
            dp[i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j] = dp[j-1] + dp[j];
            }
        }

        return dp[n-1];
    }
}
// // My Solution using DP - O(NM) Space, O(NM) Time
// class Solution {
//     int[][] dp;

//     public int uniquePaths(int m, int n) {
//         dp = new int[n][m];
//         if(m==1 && n==1)
//             return 1;
//         int res = getPathCnt(n-1, m-1);
//         return res;
//     }

//     private int getPathCnt(int n, int m){
//         if(m == 0 && n == 0){
//             return 0;
//         }else if(m==0 && n==1){
//             return 1;
//         }else if(m==1 && n==0){
//             return 1;
//         }else if(m<0 || n <0){
//             return 0;
//         }

//         if(dp[n][m] != 0){
//             return dp[n][m];
//         }

//         int res = getPathCnt(n, m-1) + getPathCnt(n-1, m);
//         dp[n][m] = res;
//         return res;
//     }
// }