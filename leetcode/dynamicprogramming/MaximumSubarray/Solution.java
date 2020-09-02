package dynamicprogramming.MaximumSubarray;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/566/
// Problem: https://leetcode.com/problems/maximum-subarray/submissions/

// My solution in O(N)
class Solution{
    public int maxSubArray(int[] nums){
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(sum + nums[i] < nums[i]){
                // Initialize the starting point
                sum = nums[i];
            }else{
                // Sum up
                sum += nums[i];
            }

            max = Math.max(max, sum);
        }
        return max;
    }
}

// My solution using recursion
// class Solution {
//     int[] nums;
//     int max = Integer.MIN_VALUE;

//     public int maxSubArray(int[] nums) {
//         this.nums = nums;
//         for(int i=0;i<nums.length;i++){
//             helper(i, 0);
//         }
//         return max;
//     }

//     private void helper(int idx, int sum){
//         if(idx >= nums.length){
//             return;
//         }

//         int n = nums[idx];

//         if(sum + n  > max){
//             max = sum + n;
//         }
//         helper(idx+1, sum + n);
//     }
// }