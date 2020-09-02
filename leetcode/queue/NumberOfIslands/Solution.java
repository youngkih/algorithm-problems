package queue.NumberOfIslands;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/
// Problem: https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1380/

class Node{
    int value;
    int x;
    int y;
    Node(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

class Solution {
    int islandNum = 0;
    int n, m;
    boolean[][] checked;
    Queue<Node> queue;

    public int numIslands(char[][] grid) {
        n = grid.length;
        if(n == 0)
            return 0;

        m = grid[0].length;

        checked = new boolean[n][m];

        // Breadth-First Search
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(!checked[i][j] && grid[i][j] == '1'){
        //              bfs(grid, i, j);
        //         }
        //     }
        // }

        // Depth-First Search using Recursion
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(!checked[i][j] && grid[i][j] == '1'){
        //             dfs(grid, i, j);
        //             islandNum++;
        //         }
        //     }
        // }

        return islandNum;
    }

    private int dfs(char[][] grid, int x, int y){
        if(grid[x][y] == '0')
            return 0;

        int[] dx = {1, -1, 0 , 0};
        int[] dy = {0, 0, 1 , -1};
        for(int i=0;i<4;i++){
            int pointX = x + dx[i];
            int pointY = y + dy[i];

            if(pointX >= 0 && pointX < n && pointY >= 0 && pointY < m){
                if(!checked[pointX][pointY]){
                    checked[pointX][pointY] = true;
                    dfs(grid, pointX, pointY);
                }
            }
        }

        return 1;
    }

    private void bfs(char[][] grid, int x, int y){
        boolean addIsland = false;
        queue = new LinkedList<Node>();

        // Handle the root node, e.g) [["1"]]
        if(!checked[x][y]){
            checked[x][y] = true;
            addIsland = true;
        }
        queue.add(new Node(x, y, grid[x][y]));

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int k=0;k<size;k++){
                Node node = queue.poll();
                int pointX, pointY;

                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1};

                for(int i=0;i<4;i++){
                    pointX = node.x + dx[i];
                    pointY = node.y + dy[i];
                    if(pointX >= 0 && pointX < n && pointY >= 0 && pointY < m){
                        if((grid[pointX][pointY] == '1') && (!checked[pointX][pointY])){
                            queue.add(new Node(pointX, pointY, grid[pointX][pointY]));
                            checked[pointX][pointY] = true;
                            addIsland = true;
                        }
                    }
                }
            }
        }
        if(addIsland){
            islandNum++;
            // System.out.println("==["+x+", "+y+"]==");
            // printChecked();
        }

    }

    private void printChecked(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(checked[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

