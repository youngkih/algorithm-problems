package tree.binary_tree_traversal.PreorderIterative;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null){
                continue;
            }
            arr.add(node.val);

            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }

        return arr;
    }
}