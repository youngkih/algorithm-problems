package RegularExpressionMatching;

// Problem: https://leetcode.com/problems/regular-expression-matching/
/*
 - DP Solution from https://www.youtube.com/watch?v=l3hda49XcDE
 - * Idea: Use 2D array like LCS problem, with multiple different conditions
*/
class Solution {
    boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new boolean[s.length()+1][p.length()+1];

        dp[0][0] = true;

        // Handle a* or a*b*.. cases
        for(int i=1;i<p.length()+1;i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<p.length()+1;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    // [...s(i)] vs [...p(j)] ==> [...s(i-1)] vs [...p(j-1)]
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    // Consider 2 cases
                    // - 0 occurrence of prev char
                    // - Multiple occurences of prev char
                    // If any of above condition is true, result will be true.
                    boolean res = false;
                    if(s.charAt(i-1) == p.charAt(j-1-1) || p.charAt(j-1-1) == '.'){
                        // Multiple ocurrences of prev char
                        // Why dp[i-1][j]? : Since it occurred multiple times, consider s[i] is included in p[j]. We can only compare s[0..i-1]
                        res = dp[i-1][j];
                    }
                    boolean res2 = dp[i][j-2]; // 0 occurrence of prev char

                    dp[i][j] = res2 || res;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}