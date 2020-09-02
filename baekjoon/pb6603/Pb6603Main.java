package pb6603;

import java.util.*;

public class Pb6603Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n, num;

        Pb6603Main myMain = new Pb6603Main();
        ArrayList<Integer> numList;
        while(true){
            n = scan.nextInt();
            if(n == 0)
                break;

            numList = new ArrayList<>();
            for(int i=0;i<n;i++){
                num = scan.nextInt();
                numList.add(num);
            }
            myMain.dfs(numList, new ArrayList<Integer>(), 0);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private void dfs(ArrayList<Integer> numList, ArrayList<Integer> resList, int idx){
        if(resList.size() == 6){
            for(int n : resList){
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx;i<numList.size();i++){
            int num = numList.get(i);
            resList.add(num);
            dfs(numList, resList, i+1);
            resList.remove(resList.indexOf(num));
        }
    }
}