package SearchInRotatedSortedArray;

class Solution {
    int[] nums;
    int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return binarySearch(0, nums.length);
    }

    private int binarySearch(int head, int tail){
        int mid = (head + tail) / 2;
        if(head > tail || mid >= nums.length){
            return -1;
        }
        if(nums[mid] == target){
            return mid;
        }

        int left = binarySearch(head, mid-1);
        int right = binarySearch(mid+1, tail);

        int res = (left >= 0)? left : right;

        return (res >= 0)? res : -1;
    }
}