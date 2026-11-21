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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        heightOfBinaryTree(root);
        return ans;
    }
    public int heightOfBinaryTree(TreeNode root){
        if(root == null) return -1;
        int lht = heightOfBinaryTree(root.left);
        int rht = heightOfBinaryTree(root.right);
        ans = Math.max(ans,lht+rht+2);
        return Math.max(lht,rht)+1;
    }
}