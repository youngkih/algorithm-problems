package tree.binary_tree_traversal.InorderIterative;

// Problem: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/
// Problem: https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1383/
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
    ArrayList<Integer> res = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return res;

        TreeNode currentNode = root;

        while(currentNode != null || !stack.isEmpty()){
            while(currentNode != null){
                stack.add(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            res.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return res;
    }

}