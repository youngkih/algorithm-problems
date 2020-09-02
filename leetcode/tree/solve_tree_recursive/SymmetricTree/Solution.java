package tree.solve_tree_recursive.SymmetricTree;

// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
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
    ArrayList<Integer> leftList = new ArrayList<Integer>();
    ArrayList<Integer> rightList = new ArrayList<Integer>();
    Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
    Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left != null){
            leftQueue.add(root.left);
        }
        if(root.right != null){
            rightQueue.add(root.right);
        }

        while(!leftQueue.isEmpty() || !rightQueue.isEmpty()){
            // Propagate left queue
            int leftSize = leftQueue.size();
            for(int i=0;i<leftSize;i++){
                TreeNode leftChild = leftQueue.poll();
                if(leftChild == null){
                    leftList.add(0);
                    continue;
                }
                leftList.add(leftChild.val);
                leftQueue.add(leftChild.left);
                leftQueue.add(leftChild.right);
            }

            // Propagate right queue
            int rightSize = rightQueue.size();
            for(int j=0;j<rightSize;j++){
                TreeNode rightChild = rightQueue.poll();
                if(rightChild == null){
                    rightList.add(0);
                    continue;
                }
                rightList.add(rightChild.val);
                rightQueue.add(rightChild.left);
                rightQueue.add(rightChild.right);
            }

            System.out.println("leftList: "+leftList);
            Collections.reverse(rightList);
            System.out.println("rightList: "+rightList);
            if(leftList.equals(rightList)){
                leftList = new ArrayList<Integer>();
                rightList = new ArrayList<Integer>();
                continue;
            }else{
                return false;
            }


        }

        return true;

    }
}