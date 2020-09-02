package linkedlist.RemoveNthNodeFromEndOfList;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/

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
// Solution from Leetcode
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // Dummy node is used for corner cases like only 1 node exists, etc
        dummy.next = head;

        ListNode firstNode = dummy;
        ListNode secondNode = dummy;

        for(int i=0;i<n;i++){
            firstNode = firstNode.next;
        }

        while(firstNode.next != null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        secondNode.next = secondNode.next.next;

        return dummy.next;
    }
}

// Solution using extra O(N) space for ArrayList
//class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ArrayList<ListNode> arrList = new ArrayList<>();
//        while(head != null){
//            arrList.add(head);
//            head = head.next;
//        }
//        int size = arrList.size();
//        if(size == 1){
//            return null;
//        }else if(size == n){
//            return arrList.get(1);
//        }else{
//            arrList.get(size - n - 1).next = arrList.get(size - n).next;
//            return arrList.get(0);
//        }
//    }
//}

// Better Solutions from Leetcode

// Solution 1
//public ListNode removeNthFromEnd(ListNode head, int n) {
//    ListNode dummy = new ListNode(0);
//    dummy.next = head;
//    int length  = 0;
//    ListNode first = head;
//    while (first != null) {
//        length++;
//        first = first.next;
//    }
//    length -= n;
//    first = dummy;
//    while (length > 0) {
//        length--;
//        first = first.next;
//    }
//    first.next = first.next.next;
//    return dummy.next;
//}

// Solution 2
//public ListNode removeNthFromEnd(ListNode head, int n) {
//    ListNode dummy = new ListNode(0);
//    dummy.next = head;
//    ListNode first = dummy;
//    ListNode second = dummy;
//    // Advances first pointer so that the gap between first and second is n nodes apart
//    for (int i = 1; i <= n + 1; i++) {
//        first = first.next;
//    }
//    // Move first to the end, maintaining the gap
//    while (first != null) {
//        first = first.next;
//        second = second.next;
//    }
//    second.next = second.next.next;
//    return dummy.next;
//}