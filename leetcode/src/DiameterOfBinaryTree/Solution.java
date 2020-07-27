package DiameterOfBinaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Solution from Leetcode - https://leetcode.com/problems/diameter-of-binary-tree/discuss/101132/Java-Solution-MaxDepth
class Solution{
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root){
        getMaxLevel(root);
        return max;
    }

    private int getMaxLevel(TreeNode node){
        if(node == null)
            return 0;

        int left = getMaxLevel(node.left);
        int right = getMaxLevel(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right)+1;
    }
}


// Solution using recursion
// - f(root) = Math.max(f(left), f(right), depth(left)+1+depth(right)+1)
// class Solution {
//     TreeNode root;

//     public int diameterOfBinaryTree(TreeNode root) {
//         this.root = root;

//         return maxDistance(root);
//     }

//     private int maxDistance(TreeNode node){
//         if(node == null)
//             return 0;

//         return Math.max(Math.max(maxDistance(node.left), maxDistance(node.right)), maxDepth(node.left) + maxDepth(node.right));
//     }

//     private int maxDepth(TreeNode node){
//         if(node == null)
//             return 0;
//         return Math.max(maxDepth(node.left), maxDepth(node.right))+1;
//     }
// }