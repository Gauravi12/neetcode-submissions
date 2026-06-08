/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node before = dummy;
        Node temp = head;
        while(temp!=null){
            Node newnode = new Node(temp.val);
            before.next = newnode;
            before = before.next;
            map.put(temp , before);
            temp = temp.next;
        }

        Node temp1 = head;
        Node before1 = dummy.next;
        while(temp1!=null){
            Node point = temp1.random;
            if(point == null){
                before1.random = point;
            }else{
                before1.random = map.get(point);
            }
            temp1 = temp1.next;
            before1 = before1.next;
        }
        return dummy.next;
    }
}
