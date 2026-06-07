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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode before1 = null;
        ListNode temp = head2;
        while(temp!=null){
            ListNode next = temp.next;
            temp.next = before1;
            before1 = temp;
            temp = next;
        }
        head2 = before1;
        ListNode dummy = new ListNode(-1);
        ListNode before = dummy;
        int count = 0;
        while(head!=null && head2!=null){
            if(count == 0){
                before.next = head;
                head = head.next;
                count = 1;
            }else{
                before.next = head2;
                head2 = head2.next;
                count = 0;
            }
            before = before.next;
        }
        if(head!=null){
            before.next = head;
        }
        if(head2!=null){
            before.next = head2;
        }
    }
}
