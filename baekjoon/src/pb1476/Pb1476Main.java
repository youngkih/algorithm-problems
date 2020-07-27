package pb1476;

import java.util.*;

public class Pb1476Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int[] input = new int[3];
        for(int i=0;i<3;i++){
            input[i] = scan.nextInt() - 1;
        }

        int i = 0;

        while(true){
            if((i % 15 == input[0]) && (i % 28 == input[1]) && (i % 19 == input[2])){
                System.out.println(i+1);
                break;
            }

            i=i+1;
        }
    }
}
