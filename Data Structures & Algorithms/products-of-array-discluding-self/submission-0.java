class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        for(int i=0,temp=1;i<n;i++){
            ans[i]=temp;
            temp*=nums[i];
        }
        for(int i=n-1,temp=1;i>=0;i--){
            ans[i]=ans[i]*temp;
            temp=temp*nums[i];
        }
        return ans;
    }
}  
