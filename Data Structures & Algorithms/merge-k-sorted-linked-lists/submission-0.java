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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode before = dummy;

        for(int i=0;i<lists.length;i++){

            ListNode temp = dummy.next;
            ListNode temp1 = lists[i];

            while(temp!=null && temp1!=null){

                if(temp.val <= temp1.val){
                    before.next = temp;
                    temp = temp.next;
                }else{
                    before.next = temp1;
                    temp1 =temp1.next;
                }
                before = before.next;
            }

            if(temp1!=null){
                before.next = temp1;
            }
            if(temp!=null){
                before.next = temp;
            }
            before = dummy;
        }

        return dummy.next;
    }
}
