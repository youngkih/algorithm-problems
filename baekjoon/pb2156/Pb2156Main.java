package pb2156;

import java.util.*;

public class Pb2156Main{
    static int[] wines;
    static int[][] dp;
    static int[] maxArr;
    static int n;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        wines = new int[n+1];
        maxArr = new int[n+1];
        dp = new int[n+1][3];
        for(int i=0;i<n;i++){
            wines[i+1] = scan.nextInt();
        }

        Pb2156Main myMain = new Pb2156Main();
        System.out.println(myMain.solve());
    }

    private int solve(){
        maxArr[1] = wines[1];
        dp[1][1] = wines[1];

        for(int i=2;i<n+1;i++){
            dp[i][1] = Math.max(Math.max(dp[i-2][1], dp[i-2][2]) + wines[i], maxArr[i-1]);
            dp[i][2] = dp[i-1][1] + wines[i];

            int rowMax = Math.max(dp[i][1], dp[i][2]);
            maxArr[i] = Math.max(maxArr[i-1], rowMax);
        }
        return maxArr[n];
    }
}