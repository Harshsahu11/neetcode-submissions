class Solution {
    public int jump(int[] nums) {
        int cEnd = 0;
        int jump = 0;
        int cMax = 0;

        for(int i=0;i<nums.length-1;i++){
            cMax = Math.max(cMax,i+nums[i]);
            if(i==cEnd){
                jump++;
                cEnd = cMax;
            }
        }
        return jump;
    }
}
