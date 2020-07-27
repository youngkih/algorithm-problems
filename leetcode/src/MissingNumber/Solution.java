package MissingNumber;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/722/

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=0;i<=nums.length;i++){
            sum += i;
        }

        for(int i=0;i<nums.length;i++){
            sum -= nums[i];
        }
        return sum;
    }
}