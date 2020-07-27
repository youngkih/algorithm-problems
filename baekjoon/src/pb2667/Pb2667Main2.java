package pb2667;

import java.util.*;

class Point{
    int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Pb2667Main2{
    static Scanner scan = new Scanner(System.in);
    static int n;
    static int[][] board;
    static boolean[][] visited;
    Stack<Point> stack = new Stack<>();

    public static void main(String[] args){
        n = scan.nextInt();
        Pb2667Main2 m = new Pb2667Main2();
        m.initializeBoard();
        ArrayList<Integer> resList = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    resList.add(m.dfs(i, j));
                }
            }
        }
        System.out.println(resList.size());
        Collections.sort(resList);
        for(int i=0;i<resList.size();i++){
            System.out.println(resList.get(i));
        }

    }

    private int dfs(int x, int y) {
        stack.push(new Point(x, y));
        int cnt = 1;

        while(!stack.isEmpty()){
            Point p = stack.pop();

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            for(int i=0;i<4;i++){
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if((newX >= 0) && (newX < n) && (newY >= 0) && (newY < n)){
                    if(!visited[newX][newY] && (board[newX][newY] == 1)){
                        visited[newX][newY] = true;
                        stack.push(new Point(newX, newY));
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private void initializeBoard() {
        visited = new boolean[n][n];
        board = new int[n][n];

        for(int i=0;i<n;i++){
            String s = scan.next();
            for(int j=0;j<n;j++){
                board[i][j] = s.charAt(j) - '0';
            }
        }
    }

    private void printBoard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }


}