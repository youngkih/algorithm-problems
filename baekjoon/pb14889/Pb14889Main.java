package pb14889;

import java.util.*;

public class Pb14889Main{
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] matrix;

    static ArrayList<Integer> numList = new ArrayList<>();
    static int totalStat = 0;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        matrix = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = scan.nextInt();
            }
            numList.add(i);
        }

        Pb14889Main myMain = new Pb14889Main();
        myMain.solve(new ArrayList<>(), 0);
        System.out.println(min);
    }

    private void solve(ArrayList<Integer> list, int idx){
        if(list.size() == n / 2){
            getComb(list, new ArrayList<Integer>(), 0);
            int res1 = totalStat;
            totalStat = 0;

            getComb(getOpList(list), new ArrayList<Integer>(), 0);
            int res2 = totalStat;
            totalStat = 0;

            min = Math.min(min, Math.abs(res1 - res2));
            return;
        }

        for(int i=idx;i<n;i++){
            list.add(i);
            solve(list, i+1);
            list.remove(list.size()-1);
            if(list.size() == 0)
                break;
        }

    }

    private ArrayList<Integer> getOpList(ArrayList<Integer> list){
        ArrayList<Integer> resList = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!list.contains(i)){
                resList.add(i);
            }
        }
        return resList;
    }

    // Get total stat of combinations set
    private void getComb(ArrayList<Integer> numList, ArrayList<Integer> resList, int idx){
        if(resList.size() == 2){
            totalStat += getStat(resList);
            return;
        }

        for(int i=idx;i<numList.size();i++){
            resList.add(numList.get(i));
            getComb(numList, new ArrayList<>(resList), i+1);
            resList.remove(resList.size()-1);
        }
    }

    private int getStat(ArrayList<Integer> list){
        int n1 = list.get(0);
        int n2 = list.get(1);
        return matrix[n1][n2] + matrix[n2][n1];
    }

    private void printArr(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}