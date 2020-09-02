package array.SingleNumber;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(myMap.containsKey(nums[i])){
                int val = myMap.get(nums[i]);
                myMap.put(nums[i], val+1);
            }else{
                myMap.put(nums[i], 1);
            }
        }

        Iterator iterator = myMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)iterator.next();
            if((int)mapElement.getValue()!=2){
                return (int)mapElement.getKey();
            }
        }
        return 0;
    }
}