package pb12015;
import java.util.*;

public class Main{
    static int n;

    public static void main(String[] args){
        Main myMain = new Main();
        myMain.solve();
    }

    private void solve(){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        System.out.println(getMaxLength(arr));
    }

    private int getMaxLength(int[] arr){
        ArrayList<Integer> arrList = new ArrayList<>();
        int[] pileArr = new int[n];

        arrList.add(arr[0]);
        pileArr[0] = 0;
        for(int i=1;i<n;i++){
            if(arr[i] > arrList.get(arrList.size()-1)){
                arrList.add(arr[i]);
                pileArr[i] = arrList.size()-1;
            }else{
                int lowerBoundIdx = findLowerBound(arrList, arr[i]);
                arrList.set(lowerBoundIdx, arr[i]);
                pileArr[i] = lowerBoundIdx;
            }
        }

        return arrList.size();
    }

    private int findLowerBound(ArrayList<Integer> arrList, int num){
        int head = 0;
        int tail = arrList.size()-1;

        while(head < tail){
            int mid = (head + tail)/2;
            int midVal = arrList.get(mid);

            if(num <= midVal){
                tail = mid;
            }else{
                head = mid+1;
            }
        }
        return tail;
    }


}