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
    public boolean check(TreeNode root , long min , long max){

        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;
        long num = root.val;
        return check(root.right , num , max) && check(root.left , min ,num);
        
    }

    public boolean isValidBST(TreeNode root) {
        return check(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }
}
