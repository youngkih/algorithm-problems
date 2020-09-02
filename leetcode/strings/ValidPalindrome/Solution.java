package strings.ValidPalindrome;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/

class Solution {
    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length()-1;

        while(head < tail){
            char c1 = s.charAt(head);
            if(!Character.isLetterOrDigit(c1)){
                head++;
                continue;
            }
            char c2 = s.charAt(tail);
            if(!Character.isLetterOrDigit(c2)){
                tail--;
                continue;
            }

            if(Character.toLowerCase(c1) != Character.toLowerCase(c2)){
                return false;
            }else{
                head++;
                tail--;
            }
        }
        return true;
    }
}