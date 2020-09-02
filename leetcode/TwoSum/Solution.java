package TwoSum;

// Problem: https://leetcode.com/problems/two-sum/
// Solution: https://leetcode.com/problems/two-sum/discuss/141/Very-short-and-simple-Java-code-for-Two-Sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        return helper(nums, target);
    }

    // Improved Solution using HashMap
    private int[] helper(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int nextNum = target - nums[i];

            if(map.containsKey(nextNum)){ // O(1)
                int idx = map.get(nextNum);
                return new int[]{idx, i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    // Brute-force
    // private int[] helper(int[] nums, int target){
    //     int[] res = new int[2];
    //     int len = nums.length;
    //     for(int i=0;i<len-1;i++){
    //         for(int j=i+1;j<len;j++){
    //             if(nums[i] + nums[j] == target){
    //                 res[0] = i;
    //                 res[1] = j;
    //                 return res;
    //             }
    //         }
    //     }
    //     return res;
    // }

}