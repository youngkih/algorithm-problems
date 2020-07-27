package recursion.LargestRectangleHistogram;

// Problem: https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/

class Solution {
    int maxHeight = Integer.MIN_VALUE;
    int maxSize, maxIndex, heightsLen;

    public int largestRectangleArea(int[] heights) {
        heightsLen = heights.length;
        for(int i=0;i<heightsLen;i++){
            if(maxHeight < heights[i]){
                maxHeight = heights[i];
                maxIndex = i;
                maxSize = maxHeight;
            }
        }

        // System.out.println("Max is "+maxHeight+", idx: "+maxIndex);
        for(int i=0;i<heightsLen;i++){
            int width = helper(heights, i);
            int size = width * heights[i];
            if(maxSize < size){
                maxSize = size;
            }
        }

        return maxSize;
    }

    // Find width
    private int helper(int[] heights, int idx){
        int i;

        int left=idx;
        for(i=idx;i>=0;i--){
            if(heights[i] < heights[idx]){
                break;
            }
            left=i;
        }

        int right=idx;
        for(i=idx;i<heights.length;i++){
            if(heights[i] < heights[idx]){
                break;
            }
            right = i;
        }
        return right-left+1;
    }



}