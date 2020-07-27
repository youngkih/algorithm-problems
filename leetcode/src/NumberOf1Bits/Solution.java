package NumberOf1Bits;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/565/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        System.out.println("n : "+n);
        int mask = 1;
        for(int i=0;i<32;i++){
            if((n & mask) != 0){
                res++;
            }
            mask = (mask << 1); // mask <<= 1;
        }
        return res;
    }
}