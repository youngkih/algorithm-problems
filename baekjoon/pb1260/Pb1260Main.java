package pb1260;

import java.util.*;


public class Pb1260Main {
    static int vertex;
    static int edge;
    static int startV;

    static int[] check;
    static int[][] arr;

    // Queue Initialization
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        vertex = scan.nextInt();
        edge = scan.nextInt();
        startV = scan.nextInt();

        arr = new int[vertex][vertex];
        int t1, t2;

        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                arr[i][j]=0;
            }
        }

        for(int i=0;i<edge;i++){
            t1 = scan.nextInt();
            t2 = scan.nextInt();
            arr[t1-1][t2-1] = 1;
            arr[t2-1][t1-1] = 1;
        }

        Pb1260Main myMain = new Pb1260Main();

        // Initialize check array
        check = new int[vertex];
        for(int i=0;i<vertex;i++){
            check[i]=0;
        }
        myMain.dfs(startV-1);


        System.out.println("");

        // Initialize check array
        check = new int[vertex];
        for(int i=0;i<vertex;i++){
            check[i]=0;
        }
        myMain.bfs(startV-1);
    }

    private void dfs(int x){
        check[x] = 1;
        System.out.print((x+1) + " ");

        for(int i=0;i<vertex;i++){

            if((check[i] == 0) && (arr[x][i] != 0) ){
                dfs(i);
            }
        }
    }

    private void bfs(int x){
        check[x] = 1;
        int y;

        queue.add(x);

        while(!queue.isEmpty()){
            y = queue.poll();
            System.out.print((y+1) + " ");
            for(int i=0;i<vertex;i++){
                if((arr[y][i]!=0) && (check[i]==0)){
                    check[i]=1;
                    queue.add(i);
                }
            }
        }
    }
}