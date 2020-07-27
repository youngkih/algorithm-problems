package tree.solve_tree_recursive.LowestCommonAncestor;

// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/
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
    ArrayList<TreeNode> arrList1 = new ArrayList<TreeNode>();
    ArrayList<TreeNode> arrList2 = new ArrayList<TreeNode>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, arrList1);
        printArr(arrList1);

        dfs(root, q, arrList2);
        printArr(arrList2);
        return findLCA(arrList1, arrList2);
    }

    private void dfs(TreeNode startNode, TreeNode endNode, ArrayList<TreeNode> arrList){
        if(startNode == null)
            return;

        arrList.add(startNode);
        if(startNode.val == endNode.val)
            return;

        dfs(startNode.left, endNode, arrList);
        dfs(startNode.right, endNode, arrList);
        if(arrList.get(arrList.size() - 1).val != endNode.val){
            arrList.remove(arrList.size() - 1);
        }

        return;
    }

    private TreeNode findLCA(ArrayList<TreeNode> arrList1, ArrayList<TreeNode> arrList2){
        int size1 = arrList1.size();
        int size2 = arrList2.size();

        TreeNode lca = null;
        int size = ((size1 > size2) ? size2: size1);

        for(int i=0;i<size;i++){
            if(arrList1.get(i).val != arrList2.get(i).val){
                break;
            }else{
                lca = arrList1.get(i);
            }
        }

        return lca;
    }

    private void printArr(ArrayList<TreeNode> arrList){
        int size = arrList.size();

        for(int i = 0;i<size;i++){
            System.out.print(arrList.get(i).val + " ");
        }
        System.out.println("");
    }
}