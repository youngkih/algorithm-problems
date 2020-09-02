package pb15954;

import java.util.*;

public class Main {
    int[] arr;
    int n, k;
    double min = Double.MAX_VALUE;

    public static void main(String[] args){
        Main myMain = new Main();
        myMain.initialize();
        myMain.solve();
    }

    private void initialize(){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n];
        k = scan.nextInt();

        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
    }

    private void solve(){
        for(int i=k;i<=n;i++){
            double minVal = minDeviation(i);
            if(minVal < min){
                min = minVal;
            }
        }

        System.out.println(min);
    }

    private double minDeviation(int len){
        double minVal = Double.MAX_VALUE;

        for(int i=0;i<n-len+1;i++){
            int sum = 0;

            for(int j=0;j<len;j++){
                sum += arr[i+j];
            }
            double m = (double)sum / len;
            double powSum = 0f;
            for(int j=0;j<len;j++){
                powSum += Math.pow(arr[i+j] - m, 2);
            }
            double v = (double)Math.sqrt( powSum / len );

            if(minVal > v){
                minVal = v;
            }
        }

        return minVal;
    }
}
