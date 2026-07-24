class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return computeMax(n-1,nums,dp);
    }
    private int computeMax(int i,int[] nums,int[] dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];

        int skip = computeMax(i-1,nums,dp);
        int rob = computeMax(i-2,nums,dp)+nums[i];
        return dp[i] = Math.max(skip,rob);
    }
}
