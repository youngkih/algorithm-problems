package pb1697;

import java.util.*;

class Point{
    int x;
    int sec;

    Point(int x, int sec){
        this.x = x;
        this.sec = sec;
    }
}

public class Pb1697Main{
    static Queue<Point> queue = new LinkedList<Point>();
    static Scanner scan = new Scanner(System.in);
    static boolean[] checked;
    static int n , k;


    Pb1697Main(){
        n = scan.nextInt();
        k = scan.nextInt();
        checked = new boolean[100002];
    }

    public static void main(String[] args){
        Pb1697Main myMain = new Pb1697Main();
        if(n == k){
            System.out.println("0");
            return;
        }
        queue.add(new Point(n, 0));
        checked[n] = true;
        myMain.bfs();
    }

    private void bfs(){
        while(!queue.isEmpty()){
            Point currentN = queue.poll();
            Point nextN;

            if((currentN.x+1 == k) || (currentN.x-1 == k) || (currentN.x*2 == k) ){
                System.out.println(currentN.sec + 1);
                break;
            }

            if((currentN.x+1>=0) && (currentN.x+1<100000) && (!checked[currentN.x + 1])){
                nextN = new Point(currentN.x + 1, currentN.sec + 1);
                queue.add(nextN);
                checked[currentN.x + 1] = true;
            }
            if((currentN.x-1>=0) && (currentN.x-1<100000) && (!checked[currentN.x - 1])){
                nextN = new Point(currentN.x - 1, currentN.sec + 1);
                queue.add(nextN);
                checked[currentN.x - 1] = true;
            }
            if((currentN.x*2>=0) && (currentN.x*2<100000) && (!checked[currentN.x * 2])){
                nextN = new Point(currentN.x * 2, currentN.sec + 1);
                queue.add(nextN);
                checked[currentN.x * 2] = true;
            }
        }
    }
}