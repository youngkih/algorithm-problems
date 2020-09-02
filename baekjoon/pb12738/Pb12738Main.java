package pb12738;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        Main myMain = new Main();
        myMain.solve(arr);
    }

    private void solve(int[] arr){
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arrList.get(arrList.size()-1) < arr[i]){
                arrList.add(arr[i]);
            }else{
                int idx = binarySearch(arrList, arr[i]);
                arrList.set(idx, arr[i]);
            }
        }

        System.out.println(arrList.size());
    }

    private int binarySearch(ArrayList<Integer> arrList, int num){
        int head = 0;
        int tail = arrList.size()-1;

        while(head < tail){
            int mid = (head + tail)/2;
            int midVal = arrList.get(mid);

            if(midVal >= num){
                tail = mid;
            }else{
                head = mid+1;
            }
        }
        return tail;
    }
}

