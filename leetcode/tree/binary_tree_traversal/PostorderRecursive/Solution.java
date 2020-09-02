package tree.binary_tree_traversal.PostorderRecursive;

// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/
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
    ArrayList<Integer> arrList = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return arrList;
        }
        if(root.left != null){
            postorderTraversal(root.left);
        }
        if(root.right != null){
            postorderTraversal(root.right);
        }
        if(root != null){
            arrList.add(root.val);
        }

        return arrList;
    }
}