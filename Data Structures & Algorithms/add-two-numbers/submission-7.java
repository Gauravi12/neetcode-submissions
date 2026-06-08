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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode before = dummy;
        int carry = 0;
        int sum = 0;

        while(temp1!=null && temp2!=null){
            ListNode newnode = new ListNode();
            sum = carry + temp1.val + temp2.val;
            if(sum < 10){
                newnode.val = sum;
                carry = 0;
            }else{
                carry = sum/10;
                newnode.val = sum%10;
            }
            before.next = newnode;
            before = before.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1!=null){
            ListNode newnode = new ListNode();
            sum = carry + temp1.val;
            if(sum < 10){
                newnode.val = sum;
                carry = 0;
            }else{
                newnode.val = sum%10;
                carry = sum/10;
            }
            before.next = newnode;
            before = before.next;
            temp1 = temp1.next;
        }

        while(temp2!=null){
            ListNode newnode = new ListNode();
            sum = carry + temp2.val;
            if(sum < 10){
                newnode.val = sum;
                carry = 0;
            }else{
                carry = sum/10;
                newnode.val = sum%10;
            }
            before.next = newnode;
            before = before.next;
            temp2 = temp2.next;
        }

        if(carry!=0){
            ListNode newnode = new ListNode();
            newnode.val = carry;
            before.next = newnode;
            before = before.next;
        }
        return dummy.next;
    }
}
