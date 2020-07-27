package linkedlist.PalindromeLinkedList;
// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// USING RECURSION - SO SMART!!
// Solution : https://leetcode.com/problems/palindrome-linked-list/discuss/181453/Java-or-5-lines-method-or-2ms-or-O(n)-or-recursive-or-easy-to-understand
class Solution {
    ListNode ref;

    public boolean isPalindrome(ListNode head) {
        ref = head;
        return helper(head);
    }

    private boolean helper(ListNode node){
        if(node == null)
            return true;

        boolean answer = helper(node.next);
        boolean isEqual = (ref.val == node.val)? true : false;
        ref = ref.next;
        return answer && isEqual;
    }
}

// Brute-force - very slow
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        String str = "/";

        while(head!=null){
            str += Integer.toString(head.val) + "/";
            head = head.next;
        }

        // System.out.println("str : "+str);
        int headStart = 0;
        int headEnd = 0;
        int tailStart = str.length() - 1;
        int tailEnd = str.length() - 1;

        while(headEnd < tailStart){
            while(str.charAt(headEnd) != '/'){
                headEnd++;
            }
            String headStr = str.substring(headStart, headEnd);
            // System.out.println("headStr : "+headStr);
            while(str.charAt(tailStart) != '/'){
                tailStart--;
            }
            String tailStr = str.substring(tailStart+1, tailEnd + 1);
            // System.out.println("tailStr : "+tailStr);
            if(!headStr.equals(tailStr)){
                return false;
            }
            headEnd += 1;
            headStart = headEnd;

            tailEnd = tailStart - 1;
            tailStart = tailEnd;
        }
        return true;
    }
}