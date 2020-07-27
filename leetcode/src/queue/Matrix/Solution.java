package queue.Matrix;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388/

class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int n, m;
    int[][] res;

    public int[][] updateMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;

        res = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] != 0){
                    bfs(matrix, i, j);
                }
            }
        }

        return res;
    }

    private void bfs(int[][] matrix, int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        int dist = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            dist++;
            for(int i=0;i<size;i++){
                Node node = queue.poll();

                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1};

                for(int j=0;j<4;j++){
                    int pointX = node.x+dx[j];
                    int pointY = node.y+dy[j];
                    if(pointX >= 0 && pointX < n && pointY >=0 && pointY < m){
                        if(matrix[pointX][pointY] == 0){
                            res[x][y] = dist;
                            return;
                        }else{
                            queue.add(new Node(pointX, pointY));
                        }
                    }
                }
            }

        }


    }

    private void printArr(int[][] matrix){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

}