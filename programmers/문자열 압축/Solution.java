// Problem: https://programmers.co.kr/learn/courses/30/lessons/60057
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        answer = getGroupStringLength(s, 6);

        int min = Integer.MAX_VALUE;
        for(int i=1;i<s.length()+1;i++){
            min = Math.min(min, getGroupStringLength(s, i));
        }
        answer = min;
        return answer;
    }

    private int getGroupStringLength(String s, int unit){
        HashMap<String, Integer> map = new HashMap<>();
        int len = s.length();
        int times = len / unit;
        int leftOver = len % unit;

        int start = 0;
        int end = unit;
        String prevStr = "";
        int cnt = 0;
        String res = "";
        for(int i=0;i<times;i++){
            String curStr = s.substring(start, end);

            if(prevStr.equals(curStr)){
                cnt++;
            }else{
                if(cnt > 1){
                    res = res + String.valueOf(cnt);
                }
                res = res + prevStr;

                cnt = 1;
                prevStr = curStr;
            }
            start += unit;
            end += unit;
        }

        if(cnt > 1){
            res = res + String.valueOf(cnt);
        }
        res = res + prevStr;

        int resLen = res.length();
        resLen += leftOver;

        return resLen;
    }


}