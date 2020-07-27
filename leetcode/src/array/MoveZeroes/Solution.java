package array.MoveZeroes;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/

class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                cnt++;
            }
        }

        int idx = 0;
        while(cnt > 0){
            if(nums[idx] == 0){
                moveForward(nums, idx);
                cnt--;
            }else{
                idx++;
            }
        }
    }

    private void moveForward(int[] nums, int start){
        for(int i=start;i<nums.length-1;i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = 0;
    }
}