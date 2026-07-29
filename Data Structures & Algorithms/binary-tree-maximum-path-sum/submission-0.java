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
    int maxsum = Integer.MIN_VALUE;
    public int path(TreeNode root){
        if(root == null) return 0;
        int left = path(root.left);
        int right = path(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        maxsum = Math.max((left + right + root.val) , maxsum);
        return root.val + Math.max(left , right);
    }
    public int maxPathSum(TreeNode root) {
        path(root);
        return maxsum;
    }
}
