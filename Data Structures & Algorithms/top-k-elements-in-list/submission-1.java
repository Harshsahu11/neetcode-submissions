class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //PriorityQueue
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->
                map.get(a)-map.get(b));
        
        for(int num : map.keySet()){
            max.add(num);
            if(max.size()>k) max.poll();
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i]=max.poll();
        }
        return result;
    }
}
