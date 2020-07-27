package sortingsearching.FirstBadVersion;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/774/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int min = 0;
        int pivot = n/2;
        int max = n;

        while(pivot > min){
            if(isBadVersion(pivot)){
                max = pivot;
                pivot = min + (max - min)/2;
            }else{
                min = pivot;
                pivot = min + (max - min)/2;
            }
        }
        return max;
    }
}


// Leetcode Solution
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int middle = start + (end-start)/2;

        while(start < end){
            middle = start + (end-start)/2;
            if(isBadVersion(middle)){
                end = middle;
            }else{
                start = middle+1;
            }
        }
        return start;
    }
}