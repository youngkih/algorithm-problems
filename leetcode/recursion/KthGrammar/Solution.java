package recursion.KthGrammar;

// Problem: https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/

class Solution {
    public int kthGrammar(int N, int K) {
        // Base case
        if(N==1)
            return 0;
        if(N==2){
            if(K==1)
                return 0;
            if(K==2)
                return 1;
        }

        int res;
        if(K % 2 == 0){
            res = kthGrammar(N-1, K/2);
            if(res == 0){
                return 1;
            }else{
                return 0;
            }
        }else{
            res = kthGrammar(N-1, K/2 + 1); // Round up column value
            if(res == 0){
                return 0;
            }else{
                return 1;
            }
        }
    }
}