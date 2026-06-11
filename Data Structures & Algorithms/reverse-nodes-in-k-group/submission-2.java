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
    public int len(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode reverse(ListNode head){
        ListNode before = null;
        ListNode temp = head;
        while(temp!=null){
            ListNode next = temp.next;
            temp.next = before;
            before = temp;
            temp = next;
        }
        return before;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = len(head);
        ListNode list = new ListNode(-1);
        ListNode previous = list;
        ListNode start = head;
        while(length >= k){
            ListNode before = null;
            ListNode begin = start;
            int count = 0;

            while(count < k){
                before = start;
                count++;
                start = start.next;
            }
            before.next = null;
            ListNode node = reverse(begin);
            previous.next = node;

            previous = begin;
            begin.next = start;

            length = length - k;
        }
        return list.next;
    }
}
