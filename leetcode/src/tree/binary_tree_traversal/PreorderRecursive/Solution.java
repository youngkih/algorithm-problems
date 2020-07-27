package tree.binary_tree_traversal.PreorderRecursive;

// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
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
    ArrayList<Integer> arr = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null){
            arr.add(root.val);
        }else{
            return arr;
        }

        if(root.left != null){
            preorderTraversal(root.left);
        }
        if(root.right != null){
            preorderTraversal(root.right);
        }

        return arr;
    }
}

