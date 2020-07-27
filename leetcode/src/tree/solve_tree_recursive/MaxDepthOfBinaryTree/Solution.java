package tree.solve_tree_recursive.MaxDepthOfBinaryTree;

// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth)+1;
    }
}

//class Solution {
//    public int maxDepth(TreeNode root) {
//        return helper(root, 0);
//    }
//
//    private int helper(TreeNode node, int depth){
//        if(node == null)
//            return depth;
//
//        int leftDepth = helper(node.left, depth+1);
//        int rightDepth = helper(node.right, depth+1);
//        return (leftDepth > rightDepth)? leftDepth : rightDepth;
//    }
//}