package RemoveElement;

// Problem: https://leetcode.com/problems/remove-element/submissions/

class Solution {
    public int removeElement(int[] nums, int val) {
        int head = 0, tail = nums.length-1;
        int len = nums.length, cnt = 0;
        while(head <= tail){
            if(nums[head] == val){
                cnt++;

                int tmp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = tmp;
                tail--;
            }else{
                head++;
            }
        }
        return (len - cnt);
    }
}