package AddTwoNumbers;

// Problem: https://leetcode.com/problems/add-two-numbers/submissions/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        return helper(res, l1, l2);
    }

    private ListNode helper(ListNode res, ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            if(res.val == 0){
                return null;
            }
            return res;
        }

        if(l1 == null && l2 != null){
            l1 = new ListNode(0);
        }
        if(l2 == null && l1 != null){
            l2 = new ListNode(0);
        }

        // System.out.println("l1:" + l1.val + ", l2: "+l2.val + ", res.val :" +res.val);
        int resultInt = l1.val + l2.val + res.val;
        ListNode resNext = new ListNode(0);

        if(resultInt >= 10){
            resNext.val += 1;
            resultInt -= 10;
        }
        res.val = resultInt;

        res.next = helper(resNext, l1.next, l2.next);
        return res;
    }
}