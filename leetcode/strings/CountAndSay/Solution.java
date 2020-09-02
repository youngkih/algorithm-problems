package strings.CountAndSay;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/886/
// Posted on : https://leetcode.com/problems/count-and-say/discuss/643771/Straightforward-Java-solution-using-recursion

class Solution {
    public String countAndSay(int n) {
        return helper(n);
    }

    private String helper(int n){
        if(n == 1){
            return "1";
        }

        String str = helper(n-1);

        String res = "";
        char prev = str.charAt(0);
        int cnt = 0;

        for(int i=0;i<str.length();i++){
            char cur = str.charAt(i);
            if(prev == cur){
                cnt++;
            }else{
                res = res + Integer.toString(cnt) + prev;
                cnt = 1;
                prev = cur;
            }
        }

        res = res + Integer.toString(cnt) + prev;

        return res;
    }
}