import java.util.*;

public class Pb9461Main{
    static long[] dp;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        Pb9461Main myMain = new Pb9461Main();
        for(int i=0;i<t;i++){
            int num = scan.nextInt();
            dp = new long[num+1];
            long res = myMain.solve(num);
            System.out.println(res);
        }
    }

    private long solve(int n){
        long res = 0;
        if(dp[n] != 0){
            return dp[n];
        }
        if(n==1 || n==2 || n==3){
            dp[n] = 1;
            return 1;
        }
        if(n==4 || n==5){
            dp[n] = 2;
            return 2;
        }
        if(n >= 6){
            long n1 = solve(n-1);
            long n2 = solve(n-5);
            res = n1+n2;
            dp[n] = res;
        }
        return res;
    }
}