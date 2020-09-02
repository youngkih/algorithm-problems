package linkedlist.LinkedListCycle;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Using Two Pointers. Space complexity: O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        do{
            if(fastPtr == null || fastPtr.next == null){
                return false;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }while(slowPtr != fastPtr);

        return true;
    }
}

// Using HashSet. Space complexity: O(N)
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();

        while(head != null){
            if(visited.contains(head)){
                return true;
            }else{
                visited.add(head);
            }
            head = head.next;
        }
        return false;
    }
}