class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        
        int[] inDegree = new int[numCourses];

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) q.offer(i);
        }

        int[] topoOrder = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            topoOrder[index++] = curr;

            for(int neighbor : adj.get(curr)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0) q.offer(neighbor);
            }
        }
        return index==numCourses ? topoOrder : new int[0];
    }
}
