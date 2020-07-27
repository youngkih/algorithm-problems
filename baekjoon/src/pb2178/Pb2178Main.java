package pb2178;

import java.util.*;

class Point{
    int x;
    int y;
    int level;

    Point(int x, int y, int l){
        this.x = x;
        this.y = y;
        this.level = l;
    }
}

public class Pb2178Main{

    static int[][] arr;
    static boolean[][] checked;
    static Scanner scan = new Scanner(System.in);
    static int n, m;
    static int min;
    static Queue<Point> queue;

    Pb2178Main(){
        String input;
        for(int i =0;i<n;i++){
            input = scan.next();
            for(int j=0;j<m;j++){
                arr[i][j] = input.charAt(j) - '0';
            }

        }
        min = n*m;
        queue = new LinkedList<Point>();
    }

    public static void main(String[] args){


        n = scan.nextInt();
        m = scan.nextInt();

        arr = new int[n][m];
        checked = new boolean[n][m];

        Pb2178Main myMain = new Pb2178Main();

        checked[0][0]=true;
        queue.add(new Point(0,0, 1));
        myMain.bfs(0,0);
        System.out.println(min);
    }



    private void bfs(int x, int y){
        while(!queue.isEmpty()){
            Point point;
            point = queue.poll();

            x = point.x;
            y = point.y;
            int l = point.level;

            if((point.x == n-1) && (point.y == m-1)){
                if(min > l){
                    min = l;
                }
            }

            if((x-1>=0) && (y>=0) && (!checked[x-1][y]) && (arr[x-1][y]==1)){
                queue.add(new Point(x-1, y, l+1));
                checked[x-1][y]=true;
            }
            if((x<n) && (y+1<m) && (!checked[x][y+1]) && (arr[x][y+1]==1)){
                queue.add(new Point(x, y+1, l+1));
                checked[x][y+1]=true;
            }
            if((x+1<n) && (y<m) && (!checked[x+1][y]) && (arr[x+1][y]==1)){
                queue.add(new Point(x+1, y, l+1));
                checked[x+1][y]=true;
            }
            if((x>=0) && (y-1>=0) && (!checked[x][y-1]) && (arr[x][y-1]==1)){
                queue.add(new Point(x, y-1, l+1));
                checked[x][y-1]=true;
            }

        }

    }

}