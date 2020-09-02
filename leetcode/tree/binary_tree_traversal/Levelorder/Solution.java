package tree.binary_tree_traversal.Levelorder;

// Problem: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/
// Problem: https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2784/
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
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        queue.add(root);
        helper(root);
        return res;
    }

    private void helper(TreeNode node){
        if(node == null)
            return;

        List<Integer> tmpList;

        while(!queue.isEmpty()){
            tmpList = new LinkedList<>();
            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode tn = queue.poll();
                tmpList.add(tn.val);
                if(tn.left != null){
                    queue.add(tn.left);
                }
                if(tn.right != null){
                    queue.add(tn.right);
                }
            }
            res.add(tmpList);
        }
    }
}