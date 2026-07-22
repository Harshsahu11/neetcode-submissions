class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,nums,target,new ArrayList<>(),ans);
        return ans;
    }
    private void backtrack(int start,int[] nums,int target,
                            List<Integer> curr,
                            List<List<Integer>> result){

        if(target<0) return;
        else if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<nums.length;i++){
            curr.add(nums[i]);
            backtrack(i,nums,target-nums[i],curr,result);
            curr.remove(curr.size()-1);
        }
    }
}
