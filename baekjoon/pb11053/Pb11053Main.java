package pb11053;
import java.util.*;

public class Main{
    static int n;
    static int[] arr, dp;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n];
        dp = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
            dp[i] = 1;
        }
        Main myMain = new Main();
        myMain.solve();
    }

    private void solve(){
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 1;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}