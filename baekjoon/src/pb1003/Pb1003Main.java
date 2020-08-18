package pb1003;

import java.util.*;

public class Pb1003Main{
    static Pair[] dp = new Pair[41];
    static boolean[] checked = new boolean[41];
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Pb1003Main myMain = new Pb1003Main();

        for(int i=0;i<dp.length;i++){
            dp[i] = new Pair(0, 0);
        }

        int[] input = new int[n];
        for(int i=0;i<n;i++){
            int num = scan.nextInt();
            input[i] = num;
        }

        for(int i=0;i<n;i++){
            int num = input[i];
            myMain.solve(num);
            sb.append(dp[num].a + " "+dp[num].b + "\n");
        }
        System.out.print(sb);
    }

    private Pair solve(int num){
        if(checked[num])
            return dp[num];
        if(num == 0){
            dp[num] = new Pair(1,0);
            checked[0] = true;
            return dp[num];
        }else if(num == 1){
            dp[num] = new Pair(0, 1);
            checked[1] = true;
            return dp[num];
        }else{
            Pair p = sumPair(solve(num-1), solve(num-2));
            dp[num] = p;
            checked[num] = true;
            return p;
        }
    }

    private Pair sumPair(Pair p1, Pair p2){
        int a = p1.a + p2.a;
        int b = p1.b + p2.b;
        return new Pair(a, b);
    }
}

class Pair{
    int a, b;

    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}