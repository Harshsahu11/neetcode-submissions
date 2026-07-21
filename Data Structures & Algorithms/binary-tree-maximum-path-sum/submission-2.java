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
        int leftValue = Math.max(0,maxSum(root.left));
        int rightValue = Math.max(0,maxSum(root.right));
        int currSum = root.val+leftValue+rightValue;
        maxValue = Math.max(currSum,maxValue);
        return root.val+Math.max(leftValue,rightValue);

    }
}
