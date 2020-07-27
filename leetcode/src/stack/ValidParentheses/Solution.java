package stack.ValidParentheses;

// https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/

class Solution {
    Stack<Character> stack = new Stack<Character>();
    ArrayList<Character> openBracketList = new ArrayList<>();
    ArrayList<Character> closeBracketList = new ArrayList<>();

    private void initializeList(){
        char[] openArr = {'(', '{', '['};
        char[] closeArr = {')', '}', ']'};

        for(char c: openArr){
            openBracketList.add(c);
        }
        for(char c: closeArr){
            closeBracketList.add(c);
        }
    }

    public boolean isValid(String s) {
        int len = s.length();
        initializeList();

        System.out.println("openlist: "+openBracketList);
        System.out.println("closelist: "+closeBracketList);

        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            System.out.println("c: "+c);

            if(openBracketList.contains(c)){
                stack.add(c);
            }else if(closeBracketList.contains(c)){
                int idx = closeBracketList.indexOf(c);

                if(stack.isEmpty()){
                    return false;
                }else{
                    char ch = stack.pop();
                    if(openBracketList.indexOf(ch) == idx){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }
        if(!stack.isEmpty())
            return false;

        return true;
    }
}