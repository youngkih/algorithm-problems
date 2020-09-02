package stack.TargetSum;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1389/

class Solution {
    int cnt = 0;
    int sum;

    public int findTargetSumWays(int[] nums, int S) {
        sum = S;

        dfs(nums, 0, 0);
        return cnt;
    }

    private void dfs(int[] nums, int idx, int res){
        if(res == sum && idx == nums.length){
            cnt++;
            return;
        }

        if(idx <= nums.length - 1){
            dfs(nums, idx+1, res + nums[idx]);
            dfs(nums, idx+1, res - nums[idx]);
        }
        return;
    }
}