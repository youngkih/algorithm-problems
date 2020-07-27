package recursion.ClimbingStairs;

// Problem: https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
// ** Fibonacci!! Check how it's using memoization

class Solution {
    HashMap<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        cache.put(1, 1);
        cache.put(2, 2);

        return helper(n);
    }

    private int helper(int n){
        if(cache.containsKey(n))
            return cache.get(n);

        int res;
        res = helper(n-1) + helper(n-2);
        cache.put(n, res);
        return res;
    }
}