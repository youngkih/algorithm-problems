package pb1904;
import java.util.*;

public class Pb1904Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        Pb1904Main myMain = new Pb1904Main();
        long res = myMain.fibo(n);
        System.out.println( res  );
    }

    private long fibo(int n){
        if(n == 1 || n == 2)
            return n;
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746; // Adding will exceed "long" range, so we should divide first
        }
        return dp[n];
    }
}