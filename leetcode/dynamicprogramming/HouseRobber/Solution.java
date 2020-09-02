package dynamicprogramming.HouseRobber;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/
// Solution: https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems. => *** VERY GOOD EXPLANATION

class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return helper(nums, nums.length-1);
    }

    private int helper(int[] nums, int idx){
        if(idx < 0)
            return 0;

        if(cache[idx] != -1){
            return cache[idx];
        }else{
            cache[idx] = Math.max(helper(nums, idx-2) + nums[idx], helper(nums, idx-1));
            return cache[idx];
        }
    }
}