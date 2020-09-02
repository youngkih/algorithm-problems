package array.RotateArray;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/

class Solution {
    public void rotate(int[] nums, int k) {
        int tmp;
        for(int cnt=0;cnt<k;cnt++){
            tmp = nums[nums.length - 1];
            for(int i=nums.length-1;i>0;i--){
                nums[i] = nums[i-1];
            }
            nums[0] = tmp;
        }
    }
}