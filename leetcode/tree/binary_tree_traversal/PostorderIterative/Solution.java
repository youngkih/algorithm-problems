package tree.binary_tree_traversal.PostorderIterative;

// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/
/**
 *  Post order traversal will insert nodes in N->R->L order.
 * This solution updates the tree itself like from Line 36, 40.
 * The purpose is to remove the already visited nodes so that we skip checking the duplicate ones.
 */
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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return arrList;
        }
        stack.push(root);

        while(!stack.isEmpty()){
            System.out.println(arrList);
            TreeNode node = stack.peek();

            if((node.left == null) && (node.right == null)){
                arrList.add(node.val);
                stack.pop();
            }else{
                if(node.right != null){
                    stack.push(node.right);
                    node.right = null;
                }
                if(node.left != null){
                    stack.push(node.left);
                    node.left = null;
                }
            }
        }

        return arrList;
    }
}