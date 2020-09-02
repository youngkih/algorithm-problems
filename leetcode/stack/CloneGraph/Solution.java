package stack.CloneGraph;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
// Solution: https://leetcode.com/problems/clone-graph/discuss/483894/BFS-with-HashMap-DFS-with-recursion
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    HashMap<Integer, Node> newNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node){
        if(node == null)
            return null;
        if(newNodeMap.containsKey(node.val))
            return newNodeMap.get(node.val);

        Node newNode = new Node(node.val);
        newNodeMap.put(newNode.val, newNode);
        for(Node neighbor : node.neighbors){
            newNode.neighbors.add(dfs(neighbor));
        }
        return newNode;
    }
}