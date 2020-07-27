package pb14226;

import java.util.*;

class Point{
    int x;
    int clipNum;

    Point(int x, int clipNum){
        this.x = x;
        this.clipNum = clipNum;
    }
}

public class Pb14226Main{
    static Scanner scan = new Scanner(System.in);
    static int s;
    static Queue<Point> queue;
    static int[][] checked;

//    pb15954.Main(){
//        s = scan.nextInt();
//    }

    public static void main(String[] args){

        Pb14226Main myMain = new Pb14226Main();
        checked = new int[2002][2002];
        queue = new LinkedList<Point>();
        queue.add(new Point(1, 0));

        for(int i=0;i<1002;i++){
            for(int j=0;j<1002;j++){
                checked[i][j] = -1;
            }
        }

        checked[1][0] = 0;
        s = scan.nextInt();
        myMain.bfs();

        int ans = -1;
        for (int i=0; i<=s; i++) {
            if (checked[s][i] != -1) {
                if (ans == -1 || ans > checked[s][i]) {
                    ans = checked[s][i];
                }
            }
        }
        System.out.println(ans);
    }

    private void bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.clipNum > s){
                continue;
            }

            // Copy
            if(checked[p.x][p.x] == -1){ // Check [p.x][p.x] because it's going to copy p.x to clipboard
//                System.out.println("Inside 1");
                queue.add(new Point(p.x, p.x));
                checked[p.x][p.x] = checked[p.x][p.clipNum]+1; // Increase the consumed time
            }

            // Paste
            if((p.x + p.clipNum <= s) && (checked[p.x+p.clipNum][p.clipNum] == -1) ){
//                System.out.println("Inside 2");
                queue.add(new Point(p.x + p.clipNum, p.clipNum));
                checked[p.x+p.clipNum][p.clipNum]=checked[p.x][p.clipNum]+1;
            }

            // Subtract 1
            if((p.x - 1 >= 0) && (checked[p.x -1][p.clipNum] == -1)){
//                System.out.println("Inside 3");
                queue.add(new Point(p.x -1, p.clipNum));
                checked[p.x-1][p.clipNum] = checked[p.x][p.clipNum]+1;
            }
        }
    }
}