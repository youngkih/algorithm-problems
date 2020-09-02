package linkedlist.DeleteNodeInLinkedList;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // O(1)
        node.val = node.next.val;
        node.next = node.next.next;
        // helper(node); // Using recursion -> O(n)
    }

    private void helper(ListNode node){
        if(node.next == null)
            return;

        node.val = node.next.val;
        if(node.next.next == null){
            node.next = null;
            return;
        }
        helper(node.next);
    }
}