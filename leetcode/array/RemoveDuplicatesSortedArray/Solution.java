package array.RemoveDuplicatesSortedArray;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int prev = nums[0];
        int cnt = 1;

        for(int i=1;i<len;i++){
            if(prev != nums[i]){
                nums[cnt++] = nums[i];
                prev = nums[i];
            }
        }

        return cnt;
    }
}