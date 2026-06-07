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
    public int length(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = length(head) - n;
        if(index == 0){
            return head.next;
        }
        ListNode temp = head;
        int count = 0;
        ListNode before = temp;
        while(count < index){
            before = temp;
            temp = temp.next;
            count++;
        }
        
        before.next = temp.next;
        return head;
    }
}
