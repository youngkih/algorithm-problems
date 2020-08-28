package pb11722;

import java.util.*;

public class Main{
    static int n;

    public static void main(String[] args){
        Main myMain = new Main();
        myMain.solve();
    }

    private void solve(){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
            dp[i] = 1;
        }

        solveDp(arr, dp);
        System.out.println(findMax(dp));
    }

    private void solveDp(int[] arr, int[] dp){
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }

    private int findMax(int[] dp){
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}