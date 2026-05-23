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
    int count = 0;
    TreeNode res = null;
    public int kthSmallest(TreeNode root, int k) {
        smallest(root,k);
        return res.val;
    }
    private void smallest(TreeNode root , int k){
        if(root==null) return;
        smallest(root.left,k);
        count++;
        if(count==k){
            res = root;
            return;
        }
        smallest(root.right,k);
    }
}
