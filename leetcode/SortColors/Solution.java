package SortColors;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;

        for(int i=0;i<=high;i++){
            if(nums[i] == 0){
                int tmp = nums[low];
                nums[low] = nums[i];
                nums[i] = tmp;
                low++;
            }else if(nums[i] == 2){
                int tmp = nums[high];
                nums[high] = nums[i];
                nums[i] = tmp;
                high--;
                i--;
            }else{

            }
        }
    }
}