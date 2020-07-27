package pb15953;

import java.util.*;

public class Pb15953Main {
    int[] firstPrize = new int[21];
    int[] secondPrize = new int[31];

    public static void main(String[] args){
        Pb15953Main myMain = new Pb15953Main();
        myMain.initialize();
        myMain.solve();
    }

    private void initialize(){
        firstPrize[0] = 500;
        for(int i=1;i<3;i++){
            firstPrize[i] = 300;
        }
        for(int i=3;i<6;i++){
            firstPrize[i] = 200;
        }
        for(int i=6;i<10;i++){
            firstPrize[i] = 50;
        }
        for(int i=10;i<15;i++){
            firstPrize[i] = 30;
        }
        for(int i=15;i<21;i++){
            firstPrize[i] = 10;
        }

        secondPrize[0] = 512;
        for(int i=1;i<3;i++){
            secondPrize[i] = 256;
        }
        for(int i=3;i<7;i++){
            secondPrize[i] = 128;
        }
        for(int i=7;i<15;i++){
            secondPrize[i] = 64;
        }
        for(int i=15;i<31;i++){
            secondPrize[i] = 32;
        }
    }

    private void solve(){
        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();
        for(int i=0;i<times;i++){
            int first = scan.nextInt() - 1;
            int second = scan.nextInt() - 1;

            int sum = 0;
            if(first >= 0 && first < 21){
                sum += firstPrize[first] * 10000;
            }
            if(second >= 0 && second < 31){
                sum += secondPrize[second] * 10000;
            }

            System.out.println(sum);
        }
    }

}
