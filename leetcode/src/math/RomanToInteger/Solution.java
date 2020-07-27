package math.RomanToInteger;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/878/

class Solution {
    HashMap<Character, Integer> map = new HashMap<>();

    private void initialize(){
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        initialize();
        int res = 0;

        for(int i=0;i<s.length()-1;i++){
            int n1 = map.get(s.charAt(i));
            int n2 = map.get(s.charAt(i+1));

            if(n1 < n2){
                n1 = n1 * (-1);
            }
            res += n1;
        }
        int last = map.get(s.charAt(s.length()-1));
        res += last;
        return res;
    }
}