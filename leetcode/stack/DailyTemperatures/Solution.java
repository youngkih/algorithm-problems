package stack.DailyTemperatures;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
// Solution: https://medium.com/@ashleywang.ads/leetcode-739-daily-temperatures-aced04f3fdb1

// Brute-Force
//class Solution {
//    public int[] dailyTemperatures(int[] T) {
//        int size = T.length;
//        int[] res = new int[size];
//
//        for(int i=0;i<size;i++){
//            for(int j=i+1;j<size;j++){
//                if(T[i] < T[j]){
//                    res[i] = j-i;
//                    break;
//                }
//            }
//        }
//
//        return res;
//    }
//}

// Stack
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int size = T.length;
        int[] res = new int[size];
        // Stack will store index numbers
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<size;i++){
            // If it finds bigger number than the top element
            while(!stack.isEmpty() && T[i] > T[stack.peek()] ){
                int num = stack.pop();
                res[num] = i-num;
            }
            stack.add(i);
        }

        return res;
    }
}