package pb1932;

import java.util.*;

class Pb1932Main{
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    static Scanner scan;
    static int n;
    static int max = 0;
    static int dp[][];
    public static void main(String[] args){
        scan = new Scanner(System.in);

        n = scan.nextInt();
        dp = new int[n][n];

        Pb1932Main myMain = new Pb1932Main();
        int res = myMain.solve();
        System.out.println(res);
    }

    private int solve(){
        initialize();

//        bottomUp();
//        return dp[0][0];
        topDown();
        return max;
    }

    private void topDown(){
        dp[0][0] = matrix.get(0).get(0);

        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][0] + matrix.get(i).get(0);
                }else if(i == j){
                    dp[i][j] = dp[i-1][i-1] + matrix.get(i).get(j);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + matrix.get(i).get(j);
                }
            }
        }

        for(int i=0;i<n;i++){
            max = Math.max(max, dp[n-1][i]);
        }
    }

    private void bottomUp(){
        for(int i=0;i<n;i++){
            dp[n-1][i] = matrix.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + matrix.get(i).get(j);
            }
        }
    }

    private void printArr(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println("");
        }
    }

    private void initialize(){
        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                list.add(scan.nextInt());
            }
            matrix.add(list);
        }
    }
}