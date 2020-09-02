package pb1149;

import java.util.*;

public class Pb1149Main{
    static int[][] dp;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        matrix = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];

        Pb1149Main myMain = new Pb1149Main();
        myMain.solve(n);
//        myMain.printArr(n);

        int min = Math.min(dp[n-1][0], dp[n-1][1]);
        min = Math.min(min, dp[n-1][2]);
        System.out.println(min);
    }

    private void printArr(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private void solve(int n){
        for(int i=1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + matrix[i][0]; // i번째 집에 R 칼라를 사용할 경우
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + matrix[i][1]; // i번째 집에 G 칼라를 사용할 경우
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + matrix[i][2]; // i번째 집에 B 칼라를 사용할 경우
        }
    }
}