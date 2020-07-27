package pb10819;
import java.util.*;

public class Pb10819Main{
    static ArrayList<Integer> arrList = new ArrayList<Integer>();
    static int max = -1;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for(int i =0; i< n;i++){
            arrList.add(scan.nextInt());
        }
        Collections.sort(arrList);
        Pb10819Main myMain = new Pb10819Main();
        do{
            int sum = myMain.calculate();
            if(sum > max){
                max = sum;
            }
//            System.out.println(arrList);

        }while(myMain.nextPermutation());
        System.out.println(max);
    }

    private int calculate(){
        int size = arrList.size();
        int sum = 0;
        for(int i = 0;i<size-1;i++){
            sum += Math.abs(arrList.get(i) - arrList.get(i+1));
        }
        return sum;
    }


    private boolean nextPermutation(){
        int size = arrList.size();

        int j = -1;
        for(int i = size-1; i>0;i-- ){
            int n = arrList.get(i-1);
            int m = arrList.get(i);

            if(n<m){
                j = i-1;
                break;
            }
            if(i==1){
                return false;
            }
        }

        for(int i=size-1;i>0;i--){
            int n = arrList.get(i);
            if(n>arrList.get(j)){
                Collections.swap(arrList, j, i);
                Collections.sort(arrList.subList(j+1, size));
                break;
            }
        }

        return true;
    }
}