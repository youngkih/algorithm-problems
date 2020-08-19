import java.util.*;

public class Pb10844Main{
    static int n;
    static int[][] dp;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dp = new int[n+1][10];

        Pb10844Main myMain = new Pb10844Main();
        myMain.solve();
    }

    private void solve(){
        for(int i=0;i<10;i++){
            dp[0][i] = 0;
            dp[1][i] = 1;
        }
        dp[1][0] = 0;

        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][1] % 1000000000;
                }else if(j == 9){
                    dp[i][j] = dp[i-1][8] % 1000000000;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        int sum = 0;
        for(int i=0;i<10;i++){
            sum = (sum + dp[n][i]) % 1000000000;
        }
        System.out.println(sum);
    }
}