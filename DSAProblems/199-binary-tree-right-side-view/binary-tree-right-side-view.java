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
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        queue.offer(root);
        while(queue.size()>0){
            int n = queue.size();
            for(int i=1;i<=n;i++){
                TreeNode rem = queue.poll();
                if(i==n){
                    ans.add(rem.val);
                }
                if(rem.left!=null) queue.add(rem.left);
                if(rem.right!=null) queue.add(rem.right);
            }
        }
        return ans;
    }
}