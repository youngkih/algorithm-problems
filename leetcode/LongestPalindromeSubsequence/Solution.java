package LongestPalindromeSubsequence;

// Another solution using reversed string?
// https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99151/Super-simple-solution-using-reversed-string


class Solution {
    /*
     DP using 2D-Array.
     col = start index, row = end index.
     If: s[start] == s[end], add 2 to the result of string between. 2 is for string at start and end index
     Else: max value of start~(end-1) and (start+1)~end becomes the result.
     Reference: https://www.youtube.com/watch?v=_nCsPn7_OgI&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=9
    */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for(int n=0;n<len;n++){
            dp[n][n] = 1;
        }

        int k = 0;

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                k = j-i-1;
                char c1 = s.charAt(k);
                char c2 = s.charAt(j);

                if(c1 == c2){
                    dp[k][j] = 2 + dp[k+1][j-1];
                }else{
                    dp[k][j] = Math.max(dp[k+1][j], dp[k][j-1]);
                }
            }
        }

        return dp[0][len-1];
    }
}