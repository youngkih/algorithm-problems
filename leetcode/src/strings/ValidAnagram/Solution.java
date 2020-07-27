package strings.ValidAnagram;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = generateMap(s);
        HashMap<Character, Integer> tMap = generateMap(t);

        return sMap.equals(tMap);
    }

    private HashMap<Character, Integer> generateMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                map.put(c, cnt+1);
            }else{
                map.put(c, 1);
            }
        }
        return map;
    }
}