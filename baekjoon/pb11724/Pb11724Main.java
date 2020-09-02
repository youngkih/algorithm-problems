package pb11724;

import java.util.*;


public class Pb11724Main {
    static ArrayList<ArrayList<Integer>> arrList;
    static int[] check;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        arrList = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<n;i++){
            arrList.add(new ArrayList<Integer>());
        }

        int t1, t2;
        for(int i=0;i<m;i++){
            t1 = scan.nextInt() - 1;
            t2 = scan.nextInt() - 1;

            arrList.get(t1).add(t2);
            arrList.get(t2).add(t1);
        }

        //Initialize check array
        check = new int[n];
        for(int i=0;i<n;i++){
            check[i] = 0;
        }

        Pb11724Main myMain = new Pb11724Main();

        int res = 0;

        for(int i=0;i<n;i++){
            if(check[i] == 0){
                myMain.dfs(i);
                res++;
            }else{
                continue;
            }
        }
        System.out.println(res);
    }

    private void dfs(int x){
        check[x] = 1;
        for(int i =0;i<arrList.get(x).size();i++){
            int y = arrList.get(x).get(i);
            if(check[y] == 0){
                dfs(y);
            }
        }
    }
}