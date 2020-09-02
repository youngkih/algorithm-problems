package pb15649;

import java.util.*;

public class Pb15649Main{
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] checked;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();
        checked = new boolean[n+1];
        Pb15649Main myMain = new Pb15649Main();
        myMain.solve(new ArrayList<Integer>());
        System.out.println(sb);
    }

    private void solve(ArrayList<Integer> list){
        if(list.size() == m){
            printList(list);
            return;
        }

        for(int i=1;i<=n;i++){
            if(checked[i])
                continue;
            checked[i] = true;
            list.add(i);
            solve(list);
            list.remove(list.size()-1); // Backtracking
            checked[i] = false;
        }
    }

    private void printList(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i) + " ");
        }
        sb.append("\n");
    }

}