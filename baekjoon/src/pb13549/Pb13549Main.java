package pb13549;

import java.util.*;

class Point{
    int pos;
    int sec;

    Point(int pos, int sec){
        this.pos = pos;
        this.sec = sec;
    }
}

public class Pb13549Main{
    static Queue<Point> queue = new LinkedList<Point>();
    static boolean[] checked;
    static int n, k;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        k = scan.nextInt();

        if(n == k){
            System.out.println("0");
            return;
        }

        checked = new boolean[200000];

        queue.add(new Point(n, 0));

        Pb13549Main myMain = new Pb13549Main();
        int res = myMain.bfs();
        System.out.println(res);
    }

    private int bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();
            checked[p.pos] = true;
//            System.out.println("Pos: "+p.pos);
            if((p.pos + 1 == k) || (p.pos - 1 == k)){
                return p.sec + 1;
            }
            if((p.pos * 2 == k)){
                return p.sec;
            }

            if((p.pos * 2 <= 100000) && (p.pos * 2 >= 0) && !(checked[p.pos * 2])){
                queue.add(new Point(p.pos * 2, p.sec));
            }
            if((p.pos - 1 <= 100000) && (p.pos - 1 >= 0) && !(checked[p.pos-1])){
                queue.add(new Point(p.pos-1, p.sec+1));
            }
            if((p.pos + 1 <= 100000) && (p.pos + 1 >= 0) && !(checked[p.pos+1])){
                queue.add(new Point(p.pos+1, p.sec+1));
            }
        }
        return -1;
    }
}