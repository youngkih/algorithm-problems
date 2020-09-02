package tree.solve_tree_recursive.PopulateNextRightPointers;

// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;

        Node newNode = root;
        while(newNode.left != null){
            populateLowerNodes(newNode);
            newNode=newNode.left;
        }
        return root;
    }

    private void populateLowerNodes(Node node){
        while(true){
            node.left.next = node.right;
            if(node.next != null){
                node.right.next = node.next.left;
                node = node.next;
            }else{
                break;
            }
        }


    }


}