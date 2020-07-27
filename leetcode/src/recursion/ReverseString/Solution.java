package recursion.ReverseString;

// Problem: https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/

class Solution {
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length-1;
        char tmp;

        while(head < tail){
            tmp = s[tail];
            s[tail] = s[head];
            s[head] = tmp;
            head++;
            tail--;
        }
        return;
    }
}

class Solution {
    boolean[] changed;
    public void reverseString(char[] s) {
        changed = new boolean[s.length];
        helper(0, s);
    }

    private void helper(int idx, char[] s){
        if(idx >= s.length || changed[idx])
            return;

        // System.out.print("idx:" +idx+" /");
        // for(char c:s)
        //     System.out.print(c);
        // System.out.println("");

        char tmp = s[idx];
        s[idx] = s[s.length-1-idx];
        s[s.length-1-idx] = tmp;
        changed[idx] = true;
        changed[s.length-1-idx] = true;
        helper(idx+1, s);
    }
}