package tree.solve_tree_recursive.PathSum;

// Problem: https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
// Solution: https://www.programcreek.com/2013/01/leetcode-path-sum/
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        if((root.left == null) && (root.right == null)){
            if(root.val == sum){
                return true;
            }else{
                return false;
            }
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}