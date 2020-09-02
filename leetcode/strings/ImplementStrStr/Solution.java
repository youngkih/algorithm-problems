package strings.ImplementStrStr;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;

        char c2 = needle.charAt(0);

        for(int i=0;i<haystack.length();i++){
            char c1 = haystack.charAt(i);

            if(c1 == c2){
                int needleLen = needle.length();

                if(i + needleLen <= haystack.length()
                        && haystack.substring(i, i+needleLen).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

}