package RomanInteger;

// Problem: https://leetcode.com/problems/roman-to-integer/submissions/

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

        int len = s.length();
        int res = 0;
        int val = 0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            val = map.get(c);
            if(i < len-1){
                char nextChar = s.charAt(i+1);

                if(map.get(c) < map.get(nextChar)){
                    val = map.get(c) * (-1);
                }
            }

            res += val;
        }
        return res;
    }
}