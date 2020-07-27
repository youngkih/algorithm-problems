package recursion.FibonacciNumber;

// Problem: https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int fib(int N) {
        map.put(0, 0);
        map.put(1, 1);

        return helper(N);
    }
    private int helper(int N){
        if(map.containsKey(N))
            return map.get(N);

        int res = helper(N-1)+helper(N-2);
        map.put(N, res);
        return res;
    }
}