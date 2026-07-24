class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] pre : prerequisites) adj.get(pre[1]).add(pre[0]);

        // 0 = unvisited, 1 = visiting (in current path), 2 = visited (safe)
        int[] state = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(state[i]==0 && hasCycle(i,adj,state)) return false;
        }
        return true;
    }
    private boolean hasCycle(int i,List<List<Integer>> adj,int[] state){
        // If we see a node that is currently in our active path, it's a cycle!
        if (state[i] == 1) return true;
        // If we see a node we've already cleared in the past, it's safe.
        if (state[i] == 2) return false;
        // Mark the current node as "visiting" (added to active path)
        state[i] = 1;
        for(int neighbor : adj.get(i)){
            if(hasCycle(neighbor,adj,state)) return true;
        }
        state[i]=2;
        return false;
    }
}
