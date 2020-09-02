package linkedlist.ReverseLinkedList;

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
// Using Recursion
class Solution {
    public ListNode reverseList(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode node){
        if(node == null || node.next == null)
            return node;

        ListNode nextNode = helper(node.next);
        node.next.next = node;  // Make the next node point to myself
        node.next = null;       // Remove my next pointer
        return nextNode;        // This will eventually return the head node(Node 5)
    }

// Using Iteration with Stack
//     public ListNode reverseList(ListNode head) {
//         Stack<ListNode> stack = new Stack<>();
//         ListNode node = head;

//         while(node != null){
//             stack.add(node);
//             node = node.next;
//         }

//         if(stack.isEmpty()){
//             return head;
//         }else{
//             ListNode headNode = stack.peek();
//             ListNode newNode = new ListNode();
//             node = stack.pop();

//             while(!stack.isEmpty()){
//                 newNode = stack.pop();
//                 node.next = newNode;
//                 node = newNode;
//             }
//             newNode.next = null;

//             return headNode;
//         }
//     }
}