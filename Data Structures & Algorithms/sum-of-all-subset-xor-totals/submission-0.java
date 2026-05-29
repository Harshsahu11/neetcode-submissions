class Solution {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        helper(nums,0,0);
        return ans;
    }
    private void helper(int[] nums,int index,int xor){
        if(index==nums.length){
            ans+=xor;
            return;
        }
        helper(nums,index+1,xor^nums[index]);
        helper(nums,index+1,xor);
    }
}