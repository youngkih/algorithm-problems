package tree.ConvertSortedArrayToBST;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        int len = nums.length;

        if(len == 0)
            return null;

        TreeNode root = helper(0, len-1);
        return root;
    }

    private TreeNode helper(int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(start, mid-1);
        node.right = helper(mid+1, end);
        return node;
    }

}