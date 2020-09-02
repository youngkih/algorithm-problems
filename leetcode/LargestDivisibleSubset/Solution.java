package LargestDivisibleSubset;

/*
- Modified Longest Increasing Subsequence Problem
- https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/#:~:text=The%20Longest%20Increasing%20Subsequence%20(LIS)%20problem%20is%20to%20find%20the,are%20sorted%20in%20increasing%20order.
- https://www.youtube.com/watch?v=Wv6DlL0Sawg
*/


class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int max = 1;
        ArrayList<Integer> resList = new ArrayList<>();
        if(nums.length == 0){
            return resList;
        }

        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // Fill out dp(LIS array)
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        // Get the sequence
        int prev = -1;
        for(int i=nums.length-1;i>=0;i--){
            if(dp[i] == max){
                if(prev % nums[i] == 0 || prev == -1){
                    resList.add(nums[i]);
                    max--;
                    prev = nums[i];
                }
            }
        }


        return resList;
    }
}