package pb14003;

import java.util.*;

public class Main{
    static int[] arr;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        Main myMain = new Main();
        myMain.solve(arr);
    }

    private void solve(int[] arr){
        int n = arr.length;
        ArrayList<Integer> arrList = new ArrayList<>();
        int[] pileArr = new int[n]; // Array that stores in which index the number is saved

        arrList.add(arr[0]);
        pileArr[0] = 0;
        for(int i=1;i<n;i++){
            if(arrList.get(arrList.size()-1) < arr[i]){
                arrList.add(arr[i]);
                pileArr[i] = arrList.size()-1;
            }else{
                int idx = binarySearch(arrList, arr[i]);
                arrList.set(idx, arr[i]);
                pileArr[i] = idx;
            }
        }

        System.out.println(arrList.size());
        getLongestIncreasingArray(pileArr, arrList.size());
    }

    private void getLongestIncreasingArray(int[] pileArr, int pileCnt){
        int num = pileCnt-1;
        ArrayList<Integer> LISArray = new ArrayList<>();

        for(int i=pileArr.length-1;i>=0;i--){
            if(pileArr[i] == num){
                LISArray.add(0, arr[i]);
                num--;
            }
        }
        for(int i=0;i<LISArray.size();i++){
            System.out.print(LISArray.get(i)+ " ");
        }
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

