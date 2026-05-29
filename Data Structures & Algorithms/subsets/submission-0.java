class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    private void helper(int index,int[] nums,List<Integer> curr,List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        helper(index+1,nums,curr,ans);
        curr.remove(curr.size()-1);
        helper(index+1,nums,curr,ans);
    }
}
