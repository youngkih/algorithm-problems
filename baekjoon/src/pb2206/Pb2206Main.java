package pb2206;

import java.util.*;

class Point{
    int x;
    int y;
    int blkRemoved;

    Point(int x, int y ,int blkRemoved){
        this.x = x;
        this.y = y;
        this.blkRemoved = blkRemoved;
    }
}

public class Pb2206Main{
    static int n, m;
    static Scanner scan = new Scanner(System.in);
    static int[][] arr;
    static int[][][] dist;
    static ArrayDeque<Point> queue = new ArrayDeque<Point>();
//    static Queue<Point> queue = new LinkedList<Point>();

    Pb2206Main(){
        String str;
        for(int i = 0;i<n;i++){
            str = scan.next();
            for(int j=0;j<m;j++){
                arr[i][j] = str.charAt(j) - '0';
                for(int k=0;k<2;k++){
                    dist[i][j][k] = -1;
                }
            }
        }
    }

    public static void main(String[] args){
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n][m];
        dist = new int[n][m][2];


        queue.add(new Point(0, 0, 0));
        Pb2206Main myMain = new Pb2206Main();
        dist[0][0][0] = 1;
        myMain.bfs();
        if((dist[n-1][m-1][0] != -1) && (dist[n-1][m-1][1]) != -1 ){
            System.out.println(Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]));
        }else if(dist[n-1][m-1][0] != -1){
            System.out.println(dist[n-1][m-1][0]);
        }else if(dist[n-1][m-1][1] != -1){
            System.out.println(dist[n-1][m-1][1]);
        }else{
            System.out.println("-1");
        }
    }

    private void bfs(){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int x;
        int y;

        while(!queue.isEmpty()){
            Point p = queue.poll();
//            System.out.println("p.x:"+p.x+", p.y:"+p.y+", dist:"+dist[p.x][p.y]);
            for(int i =0 ;i<4;i++){
                x = p.x + dx[i];
                y = p.y + dy[i];
                if((x>=0) && (x<n) && (y>=0) && (y<m) && (dist[x][y][p.blkRemoved] == -1)){
//                    System.out.println("x:"+x+", y:"+y+", dist:"+dist[p.x][p.y]);
                    if(arr[x][y] == 0){
                        queue.add(new Point(x, y, p.blkRemoved));
                        dist[x][y][p.blkRemoved] = dist[p.x][p.y][p.blkRemoved] + 1;
                    }else{
                        if(p.blkRemoved == 1){
                            continue;
                        }else{
                            queue.add(new Point(x, y, p.blkRemoved+1));
                            dist[x][y][p.blkRemoved+1] = dist[p.x][p.y][p.blkRemoved] + 1;
                        }
                    }
                }
            }
        }
    }
}