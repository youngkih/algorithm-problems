package array.PlusOne;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/

class Solution {
    public int[] plusOne(int[] digits) {
        int num;
        int up = 1;

        for(int i=digits.length-1;i>=0;i--){
            num = digits[i] + up;
            if(num >= 10){
                digits[i] = 0;
                up = 1;
            }else{
                digits[i] = num;
                up = 0;
            }
        }

        if(up == 1){
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            for(int i=0;i<digits.length;i++){
                newDigits[i+1] = digits[i];
                return newDigits;
            }
        }

        return digits;
    }
}