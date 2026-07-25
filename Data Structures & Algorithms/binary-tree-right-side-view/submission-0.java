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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        if(root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        
        while(!q.isEmpty()){

            int size = q.size();
            TreeNode to_add = null;

            for(int i=0;i<size;i++){
                to_add = q.poll();

                if(to_add.left != null){
                    q.offer(to_add.left);
                }

                if(to_add.right != null){
                    q.offer(to_add.right);
                }
            }
            
            list.add(to_add.val);
        }

        return list;
        
    }
}
