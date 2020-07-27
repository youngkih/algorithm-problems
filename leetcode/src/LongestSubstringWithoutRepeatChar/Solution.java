package LongestSubstringWithoutRepeatChar;

// Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
// Solution: https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation

// Solution using HashMap -> Runtime : 6ms, Memory: 42 MB
// Much faster than the solution using HashSet, as we don't have to update the map everytime. We just need to check the start pointer and max value
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(map.containsKey(c)){
                // Update 'start' pointer
                // ex) abcdc => start: 0, end: 4 -> start: 3, end: 4
                start = Math.max(start, map.get(c)+1);
            }
            map.put(c, i);

            // Update max
            //  max = Math.max( length of substring , previous max value )
            max = Math.max(i - start + 1, max);
        }

        return max;
    }
}

// Solution using HashSet -> Runtime : 86ms, Memory: 42 MB
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if(s.equals(""))
//            return 0;
//        HashSet<Character> set = new HashSet<>();
//        int len = 0;
//        int start = 0, end = 0;
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<s.length();i++){
//            char c = s.charAt(i);
//
//            if(set.contains(c)){
//                // Update max value
//                if(max < set.size()){
//                    max = set.size();
//                }
//
//                // Update 'start' pointer
//                // ex) abcdc => start: 0, end: 4 -> start: 3, end: 4
//                for(int j=start;j<end+1;j++){
//                    if(s.charAt(j) == c){
//                        start = j+1;
//                        break;
//                    }
//                }
//
//                end = i;
//
//                // Update Set with substring of start to end
//                set = new HashSet<>();
//                for(int j=start;j<end+1;j++){
//                    set.add(s.charAt(j));
//                }
//            }else{
//                set.add(c);
//                end++;
//            }
//        }
//        if(max < set.size()){
//            max = set.size();
//        }
//        return max;
//    }
//}
