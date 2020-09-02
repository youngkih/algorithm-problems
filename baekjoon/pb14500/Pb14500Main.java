package pb14500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pb14500Main {
    static int n = 0;
    static int m = 0;

    public static void main(String args[]){

        Pb14500Main myMain = new Pb14500Main();

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        int[][] arr = new int[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = scan.nextInt();
            }
        }

        int maxSum = 0;
        ArrayList<Integer> sumList = new ArrayList<Integer>();

        sumList.add(myMain.firstSum(arr));
        sumList.add(myMain.thirdSum(arr));
        sumList.add(myMain.fourthSum(arr));
        sumList.add(myMain.fifthSum(arr));

        Collections.sort(sumList);
        Collections.reverse(sumList);
        System.out.println(sumList.get(0));
    }

    private int firstSum(int[][] arr){
        int sum = 0;
        int tmp = 0;
        int i = 0, j=0, k=0;
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if((j+3<m)){
                    tmpList.add(arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3]);//
                }
                if((i+3<n)){
                    tmpList.add(arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+3][j]);//
                }
                if((i+1 < n)&&(j+1 < m)){
                    tmpList.add(arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i+1][j+1]);//
                }
            }
        }


        Collections.sort(tmpList);
        Collections.reverse(tmpList);


        return tmpList.get(0);
    }

    private int thirdSum(int[][] arr){
        int sum = 0;
        int tmp = 0;
        ArrayList<Integer> tmpList = new ArrayList<Integer>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){


                if((i+2 < n) && (j+1 < m)){
                    tmpList.add(arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j+1]);//
                }

                if((i+2 < n) && (j-1 >= 0)){
                    tmpList.add(arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j-1]);//
                }

                if((i+1 < n) && (j+2 < m)){
                    tmpList.add(arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j]);//
                    tmpList.add(arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+2]);//
                }

                if((i+2 < n) && (j+1 < m)){
                    tmpList.add(arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+2][j+1]);//
                    tmpList.add(arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+2][j]);//
                }

                if((i+1 < n) && (j-2 >= 0)){
                    tmpList.add(arr[i][j]+arr[i+1][j]+arr[i+1][j-1]+arr[i+1][j-2]);//
                }

                if((i+1 < n) && (j+2 < m)){
                    tmpList.add(arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2]);//
                }

                Collections.sort(tmpList);
                Collections.reverse(tmpList);

                if(tmpList.size() > 0){
                    if(tmpList.get(0) > sum){
                        sum = tmpList.get(0);
                    }
                }
                tmpList.clear();
            }
        }

        return sum;
    }

    private int fourthSum(int[][] arr){
        int sum = 0;

        ArrayList<Integer> tmpList = new ArrayList<Integer>();

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){


                if((i+2 < n) && (j+1 < m)){
                    tmpList.add(arr[i][j]+ arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j+1]);//
                }
                if((i-1 >= 0) && (j+2 < m)){
                    tmpList.add(arr[i][j]+ arr[i][j+1]+arr[i-1][j+1]+arr[i-1][j+2]);//
                }
                if((i+2 < n) && (j-1 >= 0)){
                    tmpList.add(arr[i][j]+ arr[i+1][j]+arr[i+1][j-1]+arr[i+2][j-1]);
                }
                if((i+1 < n) && (j+2 < m)){
                    tmpList.add(arr[i][j]+ arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2]);//
                }

                Collections.sort(tmpList);
                Collections.reverse(tmpList);

                if(tmpList.size() > 0){
                    if(tmpList.get(0) > sum){
                        sum = tmpList.get(0);
                    }
                }
                tmpList.clear();
            }
        }

        return sum;
    }

    private int fifthSum(int[][] arr){
        int sum = 0;
        int tmp = 0;

        ArrayList<Integer> tmpList = new ArrayList<Integer>();

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){

                if((i+1 < n) && (j+2 < m)){
                    tmpList.add(arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]);//
                }
                if((i+2 < n) && (j-1 >= 0)){
                    tmpList.add(arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j-1]);//
                }
                if((i-1 >= 0) && (j+2 < m)){
                    tmpList.add(arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i-1][j+1]);//
                }
                if((i+2 < n) && (j+1 < m)){
                    tmpList.add(arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j+1]);//
                }
                Collections.sort(tmpList);
                Collections.reverse(tmpList);

                if(tmpList.size() > 0){
                    if(tmpList.get(0) > sum){
                        sum = tmpList.get(0);
                    }
                }
                tmpList.clear();
            }
        }

        return sum;
    }
}