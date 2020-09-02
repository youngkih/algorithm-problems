package strings.ReverseInteger;

// Problem : https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/

public class Solution {
    class Solution {
        public int reverse(int x) {
            if(x == 0){
                return 0;
            }else if(x == Integer.MIN_VALUE){ // Reverse of Integer.MIN_VALUE returns overflow
                return 0;
            }

            Stack<Integer> stack = new Stack<>();
            int res = 0;
            boolean isNegative;

            if(x >= 0){
                isNegative = false;
            }else{
                isNegative = true;
                x = x * (-1);
            }

            // 123 -> Stack : [1, 2, 3]
            while(true){
                stack.push(x%10);

                if(x/10 > 0){
                    x = x/10;
                }else{
                    break;
                }
            }

            int times = 1;
            while(!stack.isEmpty()){
                int out = stack.pop();

                if(!isValid(out, times, res))
                    return 0;

                out = out * times;
                times *= 10;
                res += out;
            }
            if(isNegative){
                return res*(-1);
            }else{
                return res;
            }
        }

        private boolean isValid(int out, int times, int res){
            if(out > Integer.MAX_VALUE / times){
                return false;
            }else if(res > Integer.MAX_VALUE - (out * times)){
                return false;
            }
            return true;
        }
    }
}
