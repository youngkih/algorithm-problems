package recursion.ReverseLinkedList;

// Problem: https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/2378/
// Solution: https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode res = helper(head, null);
        System.out.println("res " +res.val);
        return res;
    }

    private ListNode helper(ListNode cur, ListNode prev){
        if(cur == null)
            return prev;

        ListNode next = cur.next;
        cur.next = prev;
        System.out.println("Updated cur(" + cur.val+")");
        ListNode res = helper(next, cur);
        System.out.println("result : "+res.val);
        return res;
    }
}