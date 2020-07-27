package recursion.Permutations;

// Problem: https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2903/

class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;

        ArrayList<Integer> arrList = new ArrayList<>();
        helper(arrList);

        return resList;
    }

    private void helper(ArrayList<Integer> arrList){
        if((arrList.size() == nums.length)){
            resList.add(new ArrayList<>(arrList));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!arrList.contains(nums[i])){
                arrList.add(nums[i]);
                helper(arrList);
                arrList.remove(arrList.indexOf(nums[i]));
            }
        }
    }
}