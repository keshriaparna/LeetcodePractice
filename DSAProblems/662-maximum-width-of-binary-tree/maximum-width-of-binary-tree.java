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
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root,1));
        int maxWidth = 0;
        while(!queue.isEmpty()){
            int currentLevelWidth = queue.peekLast().getValue()-queue.peekFirst().getValue() + 1;
            maxWidth = Math.max(maxWidth,currentLevelWidth);
            int currentLevelSize = queue.size();
            for(int i=0;i<currentLevelSize;i++){
                Pair<TreeNode,Integer> currentPair = queue.pollFirst();
                TreeNode currentNode = currentPair.getKey();
                int currentIndex = currentPair.getValue();

                if(currentNode.left!=null){
                    queue.offer(new Pair<>(currentNode.left,currentIndex * 2));
                }
                if(currentNode.right!=null){
                    queue.offer(new Pair<>(currentNode.right,currentIndex * 2 + 1));
                }
            }
        }
        return maxWidth;
    }
}