package pb2579;

import java.util.*;

public class Pb2579Main{
    static Scanner scan;
    static int num;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args){
        scan = new Scanner(System.in);
        num = scan.nextInt();
        arr = new int[num];
        dp = new int[num][2];

        Pb2579Main myMain = new Pb2579Main();
        myMain.initialize();

        if(num < 3){
            int res = 0;
            for(int i=0;i<num;i++){
                res += arr[i];
            }
            System.out.println(res);
            return;
        }else{
            myMain.solve();
        }
    }

    private void initialize(){
        for(int i=0;i<num;i++){
            arr[i] = scan.nextInt();
        }
    }

    private void solve(){
        int res = Math.max(helper(num, 0), helper(num, 1));
        System.out.println(res);
    }

    private int helper(int n, int k){
        if(k == 0){
            dp[0][0] = arr[0];
            dp[1][0] = arr[1];
            dp[2][0] = arr[0]+arr[2];

            for(int i=3;i<n;i++){
                dp[i][0] = Math.max(dp[i-2][0] + arr[i], dp[i-3][0] + arr[i-2] + arr[i]);
            }

            return dp[n-1][0];
        }else{
            dp[0][1] = 0;
            dp[1][1] = arr[0] + arr[1];
            dp[2][1] = arr[1] + arr[2];

            for(int i=3;i<n;i++){
                dp[i][1] = dp[i-1][0] + arr[i];
            }

            return dp[n-1][1];
        }
    }
}