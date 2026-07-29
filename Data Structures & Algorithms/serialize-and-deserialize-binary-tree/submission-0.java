/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root == null){
            str.append("null,");
            return str.toString();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){

            TreeNode curr = q.poll();
            if(curr == null){
                str.append("null,");
                continue;
            }
            str.append(curr.val).append(",");

            q.offer(curr.left);
            q.offer(curr.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if(arr[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i=1;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(!arr[i].equals("null")){
                TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
                curr.left = node;
                q.offer(node);
            }
            i++;

            if(!arr[i].equals("null")){
                TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
                curr.right = node;
                q.offer(node);
            }i++;
        }

        return root;
    }
}
