class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int max = n/2;

        for(int i=0;i<n;i++){
            int count = map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],count);
            if(count>max) return nums[i];
        } 
        return -1;
    }
}