package LongestCommonPrefix;

// Problem: https://leetcode.com/problems/longest-common-prefix/
// Solution: https://leetcode.com/problems/longest-common-prefix/discuss/6910/Java-code-with-13-lines

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        int shortestLen = Integer.MAX_VALUE;
        int strsCnt = strs.length;

        for(String str : strs){
            if(str.length() < shortestLen){
                shortestLen = str.length();
            }
        }
        if(shortestLen == Integer.MAX_VALUE)
            return commonPrefix;
        if(strsCnt == 1)
            return strs[0];

        char c;
        for(int i=0;i<shortestLen;i++){
            c = ' ';
            for(int j=0;j<strsCnt-1;j++){
                if(strs[j].charAt(i) == strs[j+1].charAt(i)){
                    c = strs[j].charAt(i);
                }else{
                    c = ' ';
                    break;
                }
            }
            if(c == ' '){
                break;
            }else{
                commonPrefix = commonPrefix.concat(Character.toString(c));
            }
        }


        return commonPrefix;
    }
}