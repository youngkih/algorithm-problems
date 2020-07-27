package recursion.MergeTwoSortedLists;

// Problem: https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/
// Solution: https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using-recursion

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// USING DUMMY NODE
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                dummy.next = l2;
                l2 = l2.next;
            }else{
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;
        }
        if(l1 == null){
            dummy.next = l2;
        }else if(l2 == null){
            dummy.next = l1;
        }

        return head.next;
    }
}

// USING RECURSION
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}