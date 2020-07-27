package tree.binary_tree_traversal.InorderRecursive;

// Problem : https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/
// Problem : https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2774/
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
    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode node){
        if(node == null)
            return;

        helper(node.left);
        res.add(node.val);
        helper(node.right);
    }
}