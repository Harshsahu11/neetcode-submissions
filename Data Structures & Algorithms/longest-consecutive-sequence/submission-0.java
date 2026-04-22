class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }
        int max = 0;
        for(int num : set){
            int curr = num;
            int currLen = 1;
            if(set.contains(num-1)) continue;
            else{
                while(set.contains(curr+1)){
                    curr++;
                    currLen++;
                }
                max = Math.max(max,currLen);
            }
        }
        return max;
    }
}
