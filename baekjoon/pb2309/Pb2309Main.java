package pb2309;

import java.util.*;

public class Pb2309Main{
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<Integer>();
        int sum = 0;

        for(int j=0; j<9; j++){
            input.add(scan.nextInt());
            sum += input.get(j);
        }

        // System.out.println("sum: " + sum);

        int tmpSum = 0;
        int removeI = 0, removeJ = 0;
        int over = 0;
        over = sum - 100;
        Collections.sort(input);

        outerloop:
        for(int i=0;i<9;i++){
            for(int j=0; j<9;j++){
                if (i==j) {
                    continue;
                }
                tmpSum = input.get(i) + input.get(j);
                if(tmpSum == over){
                    // System.out.println(input.get(i)+", "+input.get(i+j));
                    removeI = i;
                    removeJ = j;
                    break outerloop;
                }else if(tmpSum > over){
                    break;
                }
            }
        }

        input.remove(removeI);
        if(removeJ >= 1) {
            input.remove(removeJ-1);
        }


        for(int i=0;i<input.size();i++){
            if(i == (input.size() - 1)) {
                System.out.print(input.get(i));
            }
            else{
                System.out.println(input.get(i));

            }

        }
    }
}