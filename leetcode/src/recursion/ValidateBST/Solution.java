package recursion.ValidateBST;

// Problem : https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/
// Solution: https://leetcode.com/problems/validate-binary-search-tree/discuss/32295/Java-Solution-with-recursion
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer min, Integer max){
        if(node == null)
            return true;
        if(min!= null && node.val <= min)
            return false;
        if(max!=null && node.val >= max)
            return false;

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}