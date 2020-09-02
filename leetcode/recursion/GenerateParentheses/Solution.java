package recursion.GenerateParentheses;

// Problem: https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2772/

class Solution {
    List<String> res = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n*2;
        helper("", "(");
        return res;
    }

    private void helper(String str, String newStr){
        str += newStr;

        // Base case
        if(str.length() == n && isValid(str)){
            res.add(str);
            return;
        }

        // Recursive case
        if(str.length() < n){
            helper(str, "(");
            helper(str, ")");
        }else{
            return;
        }
    }

    private boolean isValid(String str){
        if(str.equals(""))
            return false;

        int len = str.length();
        int openCnt = 0;

        for(int i=0;i<len;i++){
            if(str.substring(i, i+1).equals("(")){
                openCnt++;
            }else{
                if(openCnt <= 0){
                    return false;
                }else{
                    openCnt--;
                }
            }
        }
        return (openCnt == 0)? true: false;
    }



}