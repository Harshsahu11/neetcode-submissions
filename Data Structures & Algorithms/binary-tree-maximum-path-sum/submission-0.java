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
    private int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxValue;
    }
    private int maxSum(TreeNode root){
        if(root==null) return 0;
        int leftGain = Math.max(maxSum(root.left),0);
        int rightGain = Math.max(maxSum(root.right),0);
        int currPathSum = root.val+leftGain+rightGain;
        maxValue = Math.max(maxValue,currPathSum);
        return root.val+Math.max(leftGain,rightGain);
    }
}
