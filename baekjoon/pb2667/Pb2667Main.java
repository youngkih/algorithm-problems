package pb2667;

import java.util.*;

public class Pb2667Main{

    static int n;
    static int[][] arr;
    static int[][] check;
    static boolean color;

    static int cnt =0;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        arr = new int[n][n];
        check = new int[n][n];
        color = false;

        for(int i =0;i<n;i++){
            String a = scan.next(); // Scan String as input

            for(int j =0;j<n;j++){
                arr[i][j] = a.charAt(j)-'0';    // Get char of the string and convert the char to int

                check[i][j] = 0;
            }
        }
        ArrayList<Integer> arrList = new ArrayList<Integer>();


        Pb2667Main myMain = new Pb2667Main();

        for(int i =0;i<n;i++){
            for(int j =0 ;j<n;j++){
                if((arr[i][j]!=0) && (check[i][j] == 0) ){
                    myMain.bfs(i, j);
                    arrList.add(cnt);
                    cnt = 0;

                }
            }
        }

        System.out.println(arrList.size());
        Collections.sort(arrList);
        for(int i = 0; i<arrList.size();i++){
            System.out.println(arrList.get(i));
        }

    }

    private void bfs(int x, int y){
        check[x][y] = 1;
        cnt++;

        if((x-1>=0) && (y<n) && (arr[x-1][y] != 0) && (check[x-1][y] == 0)){
            bfs(x-1, y);
        }
        if((x+1<n) && (y<n) && (arr[x+1][y] != 0) && (check[x+1][y] == 0)){
            bfs(x+1, y);
        }
        if((x>=0) && (y-1>=0) && (arr[x][y-1] != 0) && (check[x][y-1] == 0)){
            bfs(x, y-1);
        }
        if((x>=0) && (y+1<n) && (arr[x][y+1] != 0) && (check[x][y+1] == 0)){
            bfs(x, y+1);
        }

    }


}