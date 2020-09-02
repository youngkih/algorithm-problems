package tree.solve_tree_recursive.SerializeDeserializeBT;

// Problem: https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
// Solution: https://github.com/bephrem1/backtobackswe/blob/master/Trees%2C%20Binary%20Trees%2C%20%26%20Binary%20Search%20Trees/SerializeDeserializeBinaryTree/SerializeDeserializeBinaryTree.java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "null";

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("data: "+data);
        Queue<String> queue = new LinkedList<String>();
        String[] str = data.split(",");
        for(String s : str){
            queue.add(s);
        }

        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue){
        String s = queue.poll();
        if(s.equals("null"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));