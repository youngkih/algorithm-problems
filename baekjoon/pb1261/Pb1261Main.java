package pb1261;

import java.util.*;

// Commented out codes are the ones that used 'checked' array.
// Using 'checked' array is memory inefficient. Use dist[][] instead

class Point{
    int x;
    int y;
    //    int blk;
    Point(int x, int y){
        this.x = x;
        this.y = y;
//        this.blk = blk;
    }
}

public class Pb1261Main{
    static int n,m;
    static int[][] arr;
    //    static boolean[][] checked;
    static int[][] dist;
    static Scanner scan = new Scanner(System.in);
    //    static Deque<Point> queue = new LinkedList<Point>();
    static ArrayDeque<Point> queue = new ArrayDeque<Point>();
    static int min = Integer.MAX_VALUE;

    Pb1261Main(){
        String str;
        for(int i = 0;i<n;i++){
            str = scan.next();
            for(int j =0;j<m;j++){
                arr[i][j] = str.charAt(j) - '0';
                dist[i][j] = -1;
            }
        }
    }

    public static void main(String[] args){
        m = scan.nextInt();
        n = scan.nextInt();
        arr = new int[n][m];
        dist = new int[n][m];
//        checked = new boolean[n][m];
        Pb1261Main myMain = new Pb1261Main();
        queue.add(new Point(0, 0));
        dist[0][0]=0;
        myMain.bfs();
        System.out.println(dist[n-1][m-1]);
    }

    private void bfs(){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!queue.isEmpty()){
            Point p = queue.poll();
//            checked[p.x][p.y] = true;

//            if((p.x == (n-1)) && (p.y == (m-1)) ){
//                if(min > p.blk){
//                    min = p.blk;
//                    if(min == 0){
//                        break;
//                    }
//                }
//            }

            for(int i =0;i<4;i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
//                int blk = p.blk;

                if((x >= 0) && (x < n) && (y >= 0) && (y < m) && (dist[x][y] == -1)){
                    if(arr[x][y] == 0){
//                        queue.addFirst(new Point(x, y, blk));
                        queue.addFirst(new Point(x, y));
                        dist[x][y] = dist[p.x][p.y];
                    }else{
//                        queue.addLast(new Point(x, y, blk+1));
                        queue.addLast(new Point(x, y));
                        dist[x][y] = dist[p.x][p.y] + 1;
                    }
                }
            }
        }
    }
}
