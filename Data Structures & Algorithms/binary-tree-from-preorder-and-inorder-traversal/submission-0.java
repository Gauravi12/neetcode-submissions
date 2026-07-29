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
    public TreeNode build(int[] preorder , int prestart , int preend ,int[] inorder , int instart , int inend){
        if(prestart > preend || instart > inend) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int i = instart;
        while(i<=inend && inorder[i] != root.val){
            i++;
        }
        int leftSize = i - instart;

        root.left = build(preorder , prestart+1 , prestart+leftSize , inorder , instart , i-1);
        root.right = build(preorder , prestart+leftSize+1 , preend , inorder , i+1 , inend);
        return root;
        
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1);
    }
}
