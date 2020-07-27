// Problem: https://leetcode.com/problems/jump-game/submissions/

package JumpGame;

// TIP: Use enum to create new data type that stores 3 different values!
enum Index{
    GOOD, BAD, UNKNOWN;
}
class Solution {
    int[] nums;
    Index[] cache;
    public boolean canJump(int[] nums) {
        this.nums = nums;
        cache = new Index[nums.length];
        Arrays.fill(cache, Index.UNKNOWN);
        return helper(0);
    }

    private boolean helper(int start){
        if(start == nums.length - 1){
            return true;
        }else if(start > nums.length - 1){
            return false;
        }

        boolean res = true;
        if(cache[start] != Index.UNKNOWN){
            return (cache[start] == Index.GOOD)? true : false;
        }else{
            if(nums[start] != 0){
                for(int i=nums[start];i>=1;i--){
                    res = helper(start + i);
                    if(res){
                        cache[start] = Index.GOOD;
                        return true;
                    }
                }
                cache[start] = Index.BAD;
                return false;
            }else{
                cache[start] = Index.BAD;
                return false;
            }
        }
    }
}