class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = numbers.length;
        for(int i=0;i<n;i++){
            int comp = target - numbers[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp),i+1};
            }
            map.put(numbers[i],i+1);
        }
        return new int[]{-1,-1};
    }
}
