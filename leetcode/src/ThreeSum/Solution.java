package ThreeSum;


// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
// Solution: https://leetcode.com/problems/3sum/discuss/143636/Java-with-set
// Solution: https://leetcode.com/problems/3sum/discuss/7585/Simple-O(n2)-two-pointers-Java-solution

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int sum = 0 - nums[i];

            int head = i+1, tail = nums.length-1;
            while(head < tail){
                if(nums[head] + nums[tail] == sum){
                    set.add(new ArrayList<>(Arrays.asList(nums[i], nums[head], nums[tail])));
                    head++;
                    tail--;
                }else if(nums[head] + nums[tail] < sum){
                    head++;
                }else{
                    tail--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            // If the smallest number is >0, sum cannot be zero
            if(nums[i] > 0)
                break;

            int sum = 0 - nums[i];

            // Skip duplicate
            if(i > 0 && (nums[i-1] == nums[i]))
                continue;

            int head = i+1, tail = nums.length-1;

            while(head < tail){
                if(nums[head] + nums[tail] == sum){
                    ArrayList<Integer> arrList = new ArrayList<>();
                    arrList.add(nums[i]);
                    arrList.add(nums[head]);
                    arrList.add(nums[tail]);

                    resList.add(arrList);

                    while (head + 1 < tail && nums[head] == nums[head+1]) // Skip duplicate
                        head++;
                    while (tail -1 > head && nums[tail] == nums[tail-1]) // Skip duplicate
                        tail--;

                    head++;
                    tail--;


                }else if(nums[head] + nums[tail] > sum){
                    tail--;
                }else{
                    head++;
                }
            }
        }


        return resList;
    }

}