package array.ContainsDuplicate;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mySet = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(mySet.contains(nums[i])){
                return true;
            }
            mySet.add(nums[i]);
        }
        return false;
    }
}