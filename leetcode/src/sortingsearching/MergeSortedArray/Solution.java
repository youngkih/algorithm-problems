package sortingsearching.MergeSortedArray;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int head1 = 0, tail1 = m-1, head2 = 0;

        while(tail1 < m + n - 1){
            if(head1 > tail1){ // Rest of the nums1 is all smaller than nums2
                while(head1 < m + n){
                    nums1[head1++] = nums2[head2++];
                }
                break;
            }else if(nums1[head1] <= nums2[head2]){
                head1 += 1;
                continue;
            }else if(nums1[head1] > nums2[head2]){
                // Move nums1 to rightside 1.
                for(int i=tail1; i>=head1; i--){
                    nums1[i+1]=nums1[i];
                }
                nums1[head1] = nums2[head2];

                head2 += 1;
                tail1 += 1;
            }
        }
    }
}