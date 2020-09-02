package pb11055;

import java.util.*;

public class Main{

    public static void main(String[] args){
        Main myMain = new Main();
        myMain.solve();
    }

    private void solve(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
            dp[i] = arr[i];
        }

        updateDp(arr, dp);
        System.out.println(getMax(dp));
    }

    private void updateDp(int[] arr, int[] dp){
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
                }
            }
        }
    }

    private int getMax(int[] dp){
        int max = 0;
        for(int i=0;i<dp.length;i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}