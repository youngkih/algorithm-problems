package pb7576;

import java.util.*;

class Point{
    int x;
    int y;
    int level;

    Point(int x, int y, int level){
        this.x = x;
        this.y = y;
        this.level = level;
    }
}

public class Pb7576Main{

    static int[][] arr;
    static boolean[][] checked;

    static Scanner scan = new Scanner(System.in);
    static Queue<Point> queue = new LinkedList<Point>();
    static int n, m;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    Pb7576Main(){
        int input;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                input = scan.nextInt();
                arr[i][j] = input;
                if(input == 1){
                    queue.add(new Point(i, j, 1));
                    checked[i][j] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        m = scan.nextInt();
        n = scan.nextInt();

        arr = new int[n][m];
        checked = new boolean[n][m];


        Pb7576Main myMain = new Pb7576Main();
        myMain.bfs();

        int res = 0;
        for(int i =0 ;i<n;i++){
            for(int j =0;j<m;j++){
                if(arr[i][j] == 0){
                    System.out.println("-1");
                    return;
                }else{
                    if(res < arr[i][j]){
                        res = arr[i][j];
                    }

                }
            }
        }
        System.out.println(res-1);


    }



    private void bfs(){
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(int i =0;i<4;i++){
                int x = point.x + dx[i];
                int y = point.y + dy[i];
                int level = point.level;
                if((x >= 0) && (x<n) && (y>=0) && (y<m) && (arr[x][y] == 0) && (!checked[x][y])){
                    arr[x][y] = level + 1;
                    checked[x][y] = true;
                    queue.add(new Point(x,y,level+1));
                }
            }
        }
    }
    private void printArr(){
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

}