package pb4963;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pb4963Main {
    static Scanner scan = new Scanner(System.in);
    static int[][] check;
    static int h, w;
    static int cnt;
    public static void main(String[] args){
        Pb4963Main myMain = new Pb4963Main();

        while(true){
            w = scan.nextInt();
            h = scan.nextInt();

            check = new int[h][w];
            if(w*h == 0){
                break;
            }
            myMain.solve(h, w);
        }
    }

    private void solve(int height, int width){
        int[][] arr = new int[height][width];

        for(int i=0;i<height; i++){
            for(int j=0;j<width;j++){
                arr[i][j] = scan.nextInt();
            }
        }
        cnt = 0;
        for(int i=0;i<height; i++){
            for(int j=0;j<width;j++){
                if((check[i][j]==0) && (arr[i][j]==1)){
                    cnt++;
                    dfs(arr, i, j);

                }
            }
        }
        System.out.println(cnt);

    }

    private void dfs(int[][] arr, int i, int j){
        check[i][j] = 1;

        if((i-1>=0) && (j-1 >=0) && (check[i-1][j-1] == 0) && (arr[i-1][j-1] == 1)){
            dfs(arr, i-1, j-1);
        }
        if((i-1>=0) && (j >= 0) && (check[i-1][j] == 0) && (arr[i-1][j] == 1)){
            dfs(arr, i-1, j);
        }
        if((i-1>=0) && (j+1 < w) && (check[i-1][j+1] == 0) && (arr[i-1][j+1] == 1)){
            dfs(arr, i-1, j+1);
        }
        if((i>=0) && (j-1 >=0) && (check[i][j-1] == 0) && (arr[i][j-1] == 1)){
            dfs(arr, i, j-1);
        }
        if((i>=0) && (j+1 < w) && (check[i][j+1] == 0) && (arr[i][j+1] == 1)){
            dfs(arr, i, j+1);
        }
        if((i+1<h) && (j-1>=0) && (check[i+1][j-1] == 0) && (arr[i+1][j-1] == 1)){
            dfs(arr, i+1, j-1);
        }
        if((i+1<h) && (j>=0) && (check[i+1][j] == 0) && (arr[i+1][j] == 1)){
            dfs(arr, i+1, j);
        }
        if((i+1<h) && (j+1<w) && (check[i+1][j+1] == 0) && (arr[i+1][j+1] == 1)){
            dfs(arr, i+1, j+1);
        }
    }

}