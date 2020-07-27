package strings.LongestCommonPrefix;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        String minStr = strs[0];
        for(String s:strs){
            if(s.length() < minStr.length()){
                minStr = s;
            }
        }

        int len = minStr.length();
        String res = "";

        for(int i=0;i<len;i++){
            char prev = minStr.charAt(i);

            for(int j=0;j<strs.length;j++){
                String str = strs[j];
                char cur = str.charAt(i);
                if(prev != cur){
                    return res;
                }
            }
            res += prev;
        }
        return res;
    }
}