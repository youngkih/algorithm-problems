package pb9095;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pb9095Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int input;

        Pb9095Main myMain = new Pb9095Main();

        for(int i=0;i<num;i++){
            input = scan.nextInt();
            System.out.println(myMain.myFunc(input));
        }


    }

    private int myFunc(int input){
        int aCnt = 0, bCnt = 0, cCnt = 0;
        int a, b, c, total;
        int i, j, k;
        int sum = 0;

        aCnt = input / 3;
        for(i=aCnt; i>=0; i--){

            bCnt = (input - (i*3)) / 2;
            for(j=bCnt; j>=0; j--){

                cCnt = (input - (i*3) - (j*2));
                a = i;
                b = j;
                c = cCnt;
                total = a + b + c;
                sum += (factorial(total))/(factorial(a)*factorial(b)*factorial(c));
            }
        }
        return sum;
    }

    private int factorial(int a){
        int i=0;
        int sum = 1;

        if(a == 0) {
            return 1;
        }else{
            for(i=a;i>0;i--){
                sum *= i;
            }
            return sum;
        }
    }
}