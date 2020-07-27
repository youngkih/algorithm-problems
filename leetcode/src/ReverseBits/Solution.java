package ReverseBits;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/648/

public class Solution {
    // you need treat n as an unsigned value

    public int reverseBits(int n) {
        int[] bits = new int[32];
        bits = toReverseBitsArr(n);

        printArr(bits);

        return (int)getInt(bits);
    }

    private int[] toReverseBitsArr(int n){
        int[] bits = new int[32];
        int num;

        for(int i=0;i<32;i++){
            num = n & (1 << i);
            if(num != 0){
                bits[i] = 1;
            }else{
                bits[i] = 0;
            }
        }
        return bits;
    }

    private long getInt(int[] arr){
        long res = 0;

        for(int i=0;i<32;i++){
            res += arr[31-i] * Math.pow(2, i);
        }
        return res;
    }

    private void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println("");
    }
}