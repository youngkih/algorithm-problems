package pb10972;

import java.util.*;

public class Pb10972Main{
    static ArrayList<Integer> arrList;
    static int n;
    static int min;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        arrList = new ArrayList<Integer>();

        n = scan.nextInt();
        for(int i=0;i<n;i++){
            arrList.add(scan.nextInt());
        }
        if(n == 1){
            System.out.println("-1");
            return;
        }

        if(arrList.get(n-2) < arrList.get(n-1)){
            Collections.swap(arrList, n-2, n-1);
            for(int i =0;i<arrList.size();i++){

                System.out.print(arrList.get(i));
                if(i!=arrList.size()-1){
                    System.out.print(" ");
                }
            }
        }else{
            Pb10972Main myMain = new Pb10972Main();
            int res = myMain.solve();

            if(res==0){
                for(int i =0;i<arrList.size();i++){

                    System.out.print(arrList.get(i));
                    if(i!=arrList.size()-1){
                        System.out.print(" ");
                    }
                }
            }

        }
    }

    public int solve(){
        for(int i = n-2; i>=0;i--){
            if(arrList.get(i) > arrList.get(i+1)){
                if(i == 0){
                    System.out.println("-1");
                    return 1;
                }
                continue;
            }else{  // ith index is the main one
                int a = arrList.get(i);
                int max = n;
                for(int j=i;j<n;j++){
                    if((arrList.get(j) > a) && (max > arrList.get(j)) ) {
                        max = arrList.get(j);
                    }
                }

                int idx = arrList.indexOf(max);
                Collections.swap(arrList, i, idx);

                Collections.sort(arrList.subList(i+1, n));
                return 0;
            }
        }
        return -1;
    }
}