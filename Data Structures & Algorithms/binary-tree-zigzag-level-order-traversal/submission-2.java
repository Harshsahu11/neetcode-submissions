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
    private int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    private void nthLevel(TreeNode root,int n,List<Integer> node){
        if(root==null) return ;
        if(n==1){
            node.add(root.val);
            return;
        }
        nthLevel(root.left,n-1,node);
        nthLevel(root.right,n-1,node);
    }
    private void nthLevel2(TreeNode root,int n,List<Integer> node){
        if(root==null) return ;
        if(n==1){
            node.add(root.val);
            return;
        }
        nthLevel2(root.right,n-1,node);
        nthLevel2(root.left,n-1,node);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int level = height(root);
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        for(int i=1;i<=level;i++){
            List<Integer> temp = new ArrayList<>();
            if(i%2!=0) nthLevel(root,i,temp);
            else nthLevel2(root,i,temp);
            ans.add(temp);
        }
        return ans;
    }
}