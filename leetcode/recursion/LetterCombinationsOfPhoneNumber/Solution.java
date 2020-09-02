package recursion.LetterCombinationsOfPhoneNumber;

// Problem : https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2905/

class Solution {
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    ArrayList<String> resList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return resList;

        initializeMap();
        String str = "";

        helper(str, digits, 0); // helper("", "23", 0)
        return resList;
    }

    private void initializeMap(){
        map.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        map.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    }

    private void helper(String str, String digits, int idx){
        System.out.println("str: " + str + " , "+ idx);

        if(str.length() == digits.length()){
            resList.add(str);
            return;
        }

        String digit = digits.substring(idx, idx+1);    // "2"
        ArrayList<String> strList = map.get(digit); // ["a", "b", "c"]

        for(int j=0;j<strList.size();j++){
            str += strList.get(j);
            helper(str, digits, idx+1);
            str = str.substring(0, str.length() - 1);
        }
    }
}