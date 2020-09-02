package pb1463;

import java.util.*;

public class Pb1463Main{
    static int[] d;
    static int x;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        d = new int[x+1];
        Pb1463Main myMain = new Pb1463Main();
        System.out.println(myMain.solve(x));
    }

    // Top-Bottom
    private int solve(int x){
        if(x == 1) return 0;
        if(d[x] > 0) return d[x];
        d[x] = solve(x-1) + 1;

        if(x % 2 == 0){
            int tmp = solve(x/2) + 1;
            d[x] = Math.min(tmp, d[x]);
        }

        if(x % 3 == 0){
            int tmp = solve(x/3) + 1;
            d[x] = Math.min(tmp, d[x]);
        }
        return d[x];
    }

    // Bottom-Up
//    private int solve(int x){
//        if( x==1 ) return 0;
//        for(int i=2;i<=x;i++){
//            d[i] = d[i-1]+1;
//            if((i%2==0) && (d[i] > d[i/2]+1)){
//                d[i] = d[i/2]+1;
//            }
//            if((i%3==0) && (d[i] > d[i/3]+1)){
//                d[i] = d[i/3]+1;
//            }
//        }
//        return d[x];
//    }


}