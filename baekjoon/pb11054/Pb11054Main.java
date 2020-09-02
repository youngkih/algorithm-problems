package pb11054;

import java.util.*;

public class Main{
    static int[] arr, arrReverse;
    static int n;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        arr = new int[n];
        arrReverse = new int[n];

        for(int i=0;i<n;i++){
            int num = scan.nextInt();
            arr[i] = num;
            arrReverse[n-1-i] = num;
        }

        Main myMain = new Main();
        myMain.solve();
    }

    private void solve(){
        int[] dp = new int[n];
        int[] dpReverse = new int[n];

        updateDp(arr, dp);
        updateDp(arrReverse, dpReverse);

        System.out.println(getMax(dp, dpReverse));
    }

    private void updateDp(int[] arr, int[] dp){
        // Initialize DP array
        for(int i=0;i<n;i++){
            dp[i] = 1;
        }

        // Update DP array
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }

    private int getMax(int[] dp, int[] dpReverse){
        int max = 0;

        for(int i=0;i<n;i++){
            max = Math.max(max, dp[i] + dpReverse[n-1-i]);
        }
        return max - 1; // Minus 1 because the point meeting point is counted twice
    }
}