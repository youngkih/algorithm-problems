package LongestPalindromeSubstring;

// Problem : https://leetcode.com/problems/longest-palindromic-substring/submissions/

// Solution using Dynamic Programming
// https://leetcode.com/problems/longest-palindromic-substring/discuss/354582/Java-easy-to-understand-dp-solution-with-comments

// My Solution - Runtime 507ms, Memory 37.8 MB
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        for(int i=0;i<len;i++){
            for(int j=len-1;j>=i;j--){
                if(s.charAt(i) == s.charAt(j)){
                    if(isPalindrome(s, i, j)){
                        if(j - i + 1 > res.length()){
                            res = s.substring(i, j+1);
                        }
                        break;
                    }
                }
            }

            // If leftover string length is shorter than result string, skip checking. As we're only looking for longest palindrome
            if(res.length() >= len-i)
                break;
        }
        return res;
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}