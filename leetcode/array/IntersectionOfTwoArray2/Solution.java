package array.IntersectionOfTwoArray2;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> resList = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int nums[] = (nums1.length >= nums2.length)? nums1 : nums2;
        int minor[] = (nums1.length < nums2.length)? nums1 : nums2;

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int val = map.get(nums[i]);
                map.put(nums[i], val + 1);
            }else{
                map.put(nums[i], 1);
            }
        }

        // Check if bigger array includes smaller array's element
        for(int i=0;i<minor.length;i++){
            if(map.containsKey(minor[i])){
                int val = map.get(minor[i]);
                if(val - 1 > 0){
                    map.put(minor[i], val-1);
                }else{
                    map.remove(minor[i]);
                }
                resList.add(minor[i]);
            }
        }

        int res[] = new int[resList.size()];
        for(int i=0;i<resList.size();i++){
            res[i] = resList.get(i);
        }

        return res;
    }
}