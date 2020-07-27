package stack.DecodeString;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
// Solution: https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack

class Solution {
    String res = "";
    Stack<Integer> numStack = new Stack<>();
    Stack<String> strStack = new Stack<>();

    public String decodeString(String s) {
        int len = s.length();
        int idx = 0;

        while(idx < len){
            char c = s.charAt(idx);
            if(Character.isDigit(c)){
                String numStr = "";
                while(Character.isDigit(c)){
                    numStr += Character.toString(c);
                    idx++;
                    c = s.charAt(idx);
                }
                numStack.add(Integer.parseInt(numStr));
            }else if(c == '['){
                strStack.add(res);
                res = "";
                idx++;
            }else if(c == ']'){
                int times = numStack.pop();
                String appendStr = "";
                for(int i=0;i<times;i++){
                    appendStr = res + appendStr;
                }
                System.out.println("Append "+ res + " " + times + " times");
                res = strStack.pop() + appendStr;
                idx++;
            }else{
                res += Character.toString(c);
                idx++;
            }
        }

        return res;
    }
}