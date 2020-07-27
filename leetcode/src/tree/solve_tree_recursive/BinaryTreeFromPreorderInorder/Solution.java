package tree.solve_tree_recursive.BinaryTreeFromPreorderInorder;

// Problem: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/943/
// Solution: https://www.programcreek.com/2014/06/leetcode-construct-binary-tree-from-preorder-and-inorder-traversal-java/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length -1;
        return buildTree(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        System.out.println("preStart: "+preStart+", preEnd: "+preEnd+", inStart: "+inStart+", inEnd: "+inEnd);
        if((preStart > preEnd) || (inStart > inEnd)){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int k =0;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                k = i;
                break;
            }
        }
        System.out.println("k: "+k);
        root.left = buildTree(preorder, preStart+1, preStart + k - inStart, inorder, inStart, k-1);
        root.right = buildTree(preorder, preStart + k - inStart + 1, preEnd, inorder, k+1, inEnd);
        return root;
    }
}