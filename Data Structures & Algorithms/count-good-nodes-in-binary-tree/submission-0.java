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

    int count = 0;

    public void countNode(TreeNode root , int max){
        if(root == null) return;
        if(root.val >= max){
            count++;
        }
        int newMax = Math.max(max , root.val);
        countNode(root.right , newMax);
        countNode(root.left , newMax);
    }

    public int goodNodes(TreeNode root) {
        countNode(root , root.val);
        return count;
    }
}
