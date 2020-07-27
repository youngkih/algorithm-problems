package queue.PerfectSquares;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/

class Node{
    int val;
    int sum = 0;


    Node(int val){
        this.val = val;
    }

    public void add(){
        this.sum += Math.pow(val, 2);
    }
}

class Solution {
    Queue<Node> queue = new LinkedList<Node>();
    int total;
    int level = 0;

    public int numSquares(int n) {
        total = n;
        bfs(0);
        return level;
    }

    private void bfs(int root){
        queue.add(new Node(root));

        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                int val = node.val;
                int sum = node.sum;

                for(int j=1;;j++){
                    if(sum + doubleInt(j) == total){
                        return;
                    }
                    if(sum + doubleInt(j) > total){
                        break;
                    }
                    Node newNode = new Node(j);
                    newNode.sum = sum + doubleInt(j);
                    queue.add(newNode);
                }

            }
        }
    }
    private int doubleInt(int i){
        return i*i;
    }
}