package pb14888;

import java.util.*;

public class Pb14888Main{
    static int n;
    static int[] nums, ops;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        nums = new int[n];
        ops = new int[4];

        for(int i=0;i<n;i++){
            nums[i] = scan.nextInt();
        }
        for(int i=0;i<4;i++){
            ops[i] = scan.nextInt();
        }

        Pb14888Main myMain = new Pb14888Main();

        myMain.dfs(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private void dfs(int res, int numIdx){
        if(numIdx == n){
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        for(int i=0;i<4;i++){
            if(ops[i] > 0){
                ops[i]--;

                if(i == 0){
                    dfs(res + nums[numIdx], numIdx + 1);
                }else if(i == 1){
                    dfs(res - nums[numIdx], numIdx + 1);
                }else if(i == 2){
                    dfs(res * nums[numIdx], numIdx + 1);
                }else if(i == 3){
                    dfs(res / nums[numIdx], numIdx + 1);
                }
                ops[i]++;
            }
        }

    }
}