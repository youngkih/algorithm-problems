package pb15652;

import java.util.*;

public class Pb15652Main{
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        Pb15652Main myMain = new Pb15652Main();
        myMain.solve(new ArrayList<>());
        System.out.println(sb);
    }

    private void solve(ArrayList<Integer> list){
        if(list.size() == m){
            printList(list);
            return;
        }

        int start;
        if(list.size() == 0){
            start = 1;
        }else{
            start = list.get(list.size()-1);
        }

        for(int i=start;i<=n;i++){
            list.add(i);
            solve(list);
            list.remove(list.size()-1);
        }
    }

    private void printList(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i) + " ");
        }
        sb.append("\n");
    }
}