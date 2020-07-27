package pb10974;

import java.util.*;

public class Pb10974Main{
    static ArrayList<Integer> arrList;
    static boolean changed = false;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        arrList = new ArrayList<Integer>();
        for(int i=0; i<n;i++){
            arrList.add(i+1);
        }
        for(int m=0;m<n;m++){
            System.out.print(arrList.get(m) + " ");
        }
        System.out.println("");
        Pb10974Main myMain = new Pb10974Main();

        while(true){
            int res = myMain.findNext(n);
            if(res == 0){
                break;
            }
        }


    }

    private int findNext(int n){
        int i, j,k=n-1;

        for(i=n-1;i>0;i--){

            int t1 = arrList.get(i-1);
            int t2 = arrList.get(i);
            if(t1<t2){
                for(j=n-1;j>=i;j--){
                    if(arrList.get(j) > t1){
                        k = j;
                        break;
                    }
                }

                Collections.swap(arrList, k, i-1);
                Collections.sort(arrList.subList(i, n));
                for(int m=0;m<n;m++){
                    System.out.print(arrList.get(m) + " ");
                }
                System.out.println("");
                return 1;
            }else{
                if(i==1){
                    return 0;
                }
                continue;
            }

        }
        return 0;

    }
}