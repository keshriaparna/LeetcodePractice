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
    public TreeNode bstToGst(TreeNode root) {
        bstToGstHelper(root);
        return root;
    }
    int sum = 0;
    public void bstToGstHelper(TreeNode root){
        if(root == null) return;
        bstToGstHelper(root.right);
        sum = sum + root.val;
        root.val = sum;
        bstToGstHelper(root.left);
    }
}