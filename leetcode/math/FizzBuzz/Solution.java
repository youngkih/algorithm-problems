package math.FizzBuzz;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/743/

class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>();

        for(int i=1;i<=n;i++){
            String str = "";

            if(i % 3 == 0){
                str += "Fizz";
            }
            if(i % 5 == 0){
                str += "Buzz";
            }
            if(str.equals("")){
                str += Integer.toString(i);
            }
            res.add(str);
        }

        return res;
    }
}