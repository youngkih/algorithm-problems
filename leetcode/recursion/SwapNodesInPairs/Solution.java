package recursion.SwapNodesInPairs;

// Problem: https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
// Solution: https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11030/My-accepted-java-code.-used-recursion

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode node = helper(head);
        return node;
    }

    private ListNode helper(ListNode node){
        ListNode nextNode = node.next;
        if(nextNode == null)
            return node;

        if(nextNode.next == null){
            nextNode.next = node;
            node.next = null;
            return nextNode;
        }

        ListNode nextNextNode = nextNode.next;
        nextNode.next = node;

        node.next = helper(nextNextNode);
        return nextNode;
    }


}