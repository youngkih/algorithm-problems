package pb15650;

import java.util.*;

public class Pb15650Main{
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        Pb15650Main myMain = new Pb15650Main();
        myMain.solve(new ArrayList<>(), 1);
        System.out.println(sb);
    }

    private void solve(ArrayList<Integer> list, int num){
        if(list.size() == m){
            printList(list);
            return;
        }

        for(int i=num;i<=n;i++){
            list.add(i);
            solve(list, i+1);
            list.remove(list.size()-1);
        }

    }

    private void printList(ArrayList<Integer> list){
        for(int i : list){
            sb.append(i + " ");
        }
        sb.append("\n");
    }
}