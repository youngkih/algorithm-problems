package stack.EvaluateReversePolishNotation;

// Problem: https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String arg1 = "";
        String arg2 = "";
        int res = 0;
        HashSet<String> opSet = new HashSet<>();

        opSet.add("+");
        opSet.add("-");
        opSet.add("*");
        opSet.add("/");

        for(String s: tokens){
            if(opSet.contains(s)){
                arg2 = stack.pop();
                arg1 = stack.pop();
                // System.out.println(arg1 + s + arg2);

                switch(s){
                    case "+":
                        res = Integer.parseInt(arg1) + Integer.parseInt(arg2);
                        break;
                    case "-":
                        res = Integer.parseInt(arg1) - Integer.parseInt(arg2);
                        break;
                    case "*":
                        res = Integer.parseInt(arg1) * Integer.parseInt(arg2);
                        break;
                    case "/":
                        res = Integer.parseInt(arg1) / Integer.parseInt(arg2);
                        break;
                    default:
                        System.out.println("default");
                }

                // System.out.println("res: "+res);

                arg2 = Integer.toString(res);
                stack.add(arg2);
            }else{
                stack.add(s);
            }
        }

        if(!stack.isEmpty()){
            res = Integer.parseInt(stack.pop());
        }

        return res;
    }
}