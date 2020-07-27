package tree.solve_tree_recursive.PopulateNextRightPointers2;

// Problem: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/1016/
// Solution: https://github.com/haoel/leetcode/blob/master/algorithms/cpp/populatingNextRightPointersInEachNode/populatingNextRightPointersInEachNode.II.cpp

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

        if(root.left != null && root.right != null)
            root.left.next = root.right;

        if(root.next!=null){
            Node leftNode = null;
            if(root.left!=null){
                leftNode = root.left;
            }
            if(root.right!=null){
                leftNode = root.right;
            }

            Node nextNode = root.next;
            Node rightNode = null;
            while(true){
                if(nextNode == null){
                    break;
                }
                if(nextNode.left != null){
                    rightNode = nextNode.left;
                    break;
                }
                if(nextNode.right !=null){
                    rightNode = nextNode.right;
                    break;
                }
                nextNode = nextNode.next;
            }
            if(leftNode != null){
                leftNode.next = rightNode;
            }
        }

        connect(root.right); // Have to run right nodes first to set the 'next' nodes of left nodes. If not, left nodes will consider there are no 'next' nodes, so will stop in the middle.
        connect(root.left);
        return root;
    }


}