package design.ShuffleAnArray;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/670/

// Using the Fisher-Yates algorithm
class Solution {
    int[] nums, newNums;

    public Solution(int[] nums) {
        this.nums = nums;
        newNums = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return newNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0;i<nums.length;i++){
            int switchIdx = getRandom(i, nums.length);
            swapAt(i, switchIdx);
        }

        return nums;
    }

    private int getRandom(int min, int max){
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */