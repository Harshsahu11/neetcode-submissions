class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                maxOnes = Math.max(maxOnes,curr);
                curr = 0;
            }
            else curr++;
        }
        maxOnes = Math.max(maxOnes,curr);
        return maxOnes;
    }
}