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
    public TreeNode deleteNode(TreeNode root, int target) {
        if (root == null) return null;
        if(root.val > target) root.left = deleteNode(root.left,target);
        else if(root.val < target) root.right = deleteNode(root.right,target);
        else{
            //case 1(0 child)
            if(root.left==null && root.right==null) return null;
            //case 2 (1 Child)
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            //case 3 (2 Child)
            TreeNode pred = root.left;
            while(pred.right!=null) pred=pred.right;
            root.left = deleteNode(root.left,pred.val);
            pred.left = root.left;
            pred.right = root.right;
            return pred;
        }
        return root;
    }
}