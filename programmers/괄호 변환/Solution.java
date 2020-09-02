// Problem: https://programmers.co.kr/learn/courses/30/lessons/60058#
import java.util.*;

class StringPair{
    String u;
    String v;

    StringPair(String u, String v){
        this.u = u;
        this.v = v;
    }
}

class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.equals(""))
            return "";

        answer = solve(s);
        System.out.println(answer);
        return answer;
    }

    private String solve(String s){
        if(s.equals(""))
            return "";

        StringPair sp = splitString(s);
        String result = "";
        if(isValid(sp.u)){
            result = sp.u + solve(sp.v);
        }else{
            result += "(";
            result += solve(sp.v);
            result += ")";
            String trimStr = sp.u.substring(1, sp.u.length()-1);
            String flStr = flipString(trimStr);
            result += flStr;
        }

        return result;
    }

    private String flipString(String s){

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c == '('){
                s = s.substring(0, i) + ")" + s.substring(i+1, s.length());
            }else{
                s = s.substring(0, i) + "(" + s.substring(i+1, s.length());
            }
        }
        return s;
    }

    private StringPair splitString(String s){
        int num = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                num++;
            }else{
                num--;
            }

            if(num == 0){
                return new StringPair(s.substring(0, i+1), s.substring(i+1, s.length()));
            }
        }
        return null;
    }

    private boolean isBalanced(String s){
        int num = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                num++;
            }else{
                num--;
            }
        }

        return (num == 0)? true : false;
    }

    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return true;
    }
}

