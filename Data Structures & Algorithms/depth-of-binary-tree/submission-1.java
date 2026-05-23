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
    public int maxDepth(TreeNode root) {
        return levels(root);
    }
    private int levels(TreeNode root){
        if(root==null) return 0;
        int leftL = levels(root.left);
        int rightL = levels(root.right);
        return 1+Math.max(leftL,rightL);
    }
}
