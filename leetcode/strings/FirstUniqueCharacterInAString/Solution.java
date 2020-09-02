package strings.FirstUniqueCharacterInAString;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int times = map.get(c);
                map.put(c, times + 1);
            }else{
                map.put(c, 1);
            }
        }

        for(int i=0;i<s.length();i++){ // *** KEY POINT! JUST ITERATE THROUGH THE STRING
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}

//class Solution {
//    public int firstUniqChar(String s) {
//        HashMap<Character, ArrayList<Integer>> map = new HashMap<>(); // {char: {index, times}}
//
//        for(int i=0;i<s.length();i++){
//            char c = s.charAt(i);
//            if(map.containsKey(c)){
//                ArrayList<Integer> arrList = map.get(c);
//                arrList.set(1, arrList.get(1) + 1); // Increase the times value
//            }else{
//                ArrayList<Integer> arrList = new ArrayList<>();
//                arrList.add(i); // Index
//                arrList.add(1); // Times
//                map.put(c, arrList);
//            }
//        }
//        System.out.println(map);
//        int min = Integer.MAX_VALUE;
//        for(Character c : map.keySet()){
//            ArrayList<Integer> arrList = map.get(c);
//            if(arrList.get(1) == 1){
//                if(arrList.get(0) < min){
//                    min = arrList.get(0);
//                }
//            }
//        }
//        if(min == Integer.MAX_VALUE){
//            return -1;
//        }
//        return min;
//    }
//}