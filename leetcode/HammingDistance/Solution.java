package HammingDistance;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/762/

// Bit Manipulation is the key point
class Solution {
    public int hammingDistance(int x, int y) {
        int[] arr1 = toBitArray(x);
        int[] arr2 = toBitArray(y);

        int cnt = 0;
        for(int i=0;i<32;i++){
            if(arr1[i] != arr2[i]){
                cnt++;
            }
        }
        return cnt;
    }

    private int[] toBitArray(int n){
        int[] arr = new int[32];
        for(int i=0;i<32;i++){
            // By shifting 1 to left and AND operating,
            // we can check if the number is not zero on that bit
            int num = n & (1 << i);

            int j = 31-i;
            if(num!=0){
                arr[j] = 1;
            }else{
                arr[j] = 0;
            }
        }
        return arr;
    }
}