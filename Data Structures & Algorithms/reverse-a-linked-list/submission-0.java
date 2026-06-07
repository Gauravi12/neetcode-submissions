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

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode before = null;
        ListNode temp = head;

        while (temp != null) {

            ListNode next = temp.next; // save next node

            temp.next = before;        // reverse link

            before = temp;            // move before forward

            temp = next;              // move temp forward
        }

        return before;
    }
}