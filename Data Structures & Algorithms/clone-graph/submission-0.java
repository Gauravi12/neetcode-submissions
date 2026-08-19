/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node , Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(node.val);
        map.put(node , root);
        q.offer(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(int i=0;i<curr.neighbors.size();i++){
                if(!map.containsKey(curr.neighbors.get(i))){
                    Node newnode = new Node(curr.neighbors.get(i).val);
                    map.put(curr.neighbors.get(i) , newnode);
                    q.offer(curr.neighbors.get(i));
                }
                map.get(curr).neighbors.add(map.get(curr.neighbors.get(i)));
            }
        }

        return map.get(node);
    }
}