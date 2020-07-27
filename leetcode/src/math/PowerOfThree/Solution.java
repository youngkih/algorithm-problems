package math.PowerOfThree;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/745/

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        return helper(n);
    }

    private boolean helper(int n){
        if(n == 1)
            return true;

        if(n % 3 != 0){
            return false;
        }else{
            return helper(n / 3);
        }
    }
}