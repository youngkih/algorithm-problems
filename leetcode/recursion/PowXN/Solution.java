package recursion.PowXN;

// Problem: https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
// Solution: https://leetcode.com/problems/powx-n/discuss/19593/O-(logn)-solution-in-Java

class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        double val = myPow(x, n/2);
        if(n%2 == 0){
            return val * val;
        }else{
            if(n > 0){
                return x * val * val;
            }else{
                return val * val / x;
            }
        }
    }
}