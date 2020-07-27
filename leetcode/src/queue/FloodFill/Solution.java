package queue.FloodFill;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/
// Other solution: https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/discuss/109584/Java-9-liner-DFS

class Node{
    int x, y;
    int color;
    Node(int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

class Solution {
    int n, m, newColor;
    int initColor;
    int[][] matrix;
    boolean[][] visited;
    Queue<Node> queue = new LinkedList<>();

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Initialization
        n = image.length;
        m = image[0].length;
        this.newColor = newColor;
        System.out.println("n, m : "+n+", "+m);

        matrix = image; // Make matrix array accessible from private method
        visited = new boolean[n][m];
        initColor = image[sr][sc]; // Flood fill only to the same color as initColor

        Node node = new Node(sr, sc, newColor);

        matrix[sr][sc] = newColor;

        queue.add(node);
        bfs();

        return image;
    }

    private void bfs(){
        while(!queue.isEmpty()){
            Node node = queue.poll();
            visited[node.x][node.y] = true;

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            for(int i=0;i<4;i++){
                int pointX = node.x + dx[i];
                int pointY = node.y + dy[i];

                if(pointX >=0 && pointX < n && pointY >=0 && pointY < m){
                    if(!visited[pointX][pointY] && matrix[pointX][pointY]==initColor){
                        matrix[pointX][pointY] = this.newColor;
                        queue.add(new Node(pointX, pointY, this.newColor));
                    }
                }
            }

        }
    }
}