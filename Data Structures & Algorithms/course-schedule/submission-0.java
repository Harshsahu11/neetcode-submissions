class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        int[] inDegree = new int[numCourses];

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(prerequisite).add(course);
            inDegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) q.offer(i);
        }
        int courseTaken = 0;

        while(!q.isEmpty()){
            int currentCourse = q.poll();
            courseTaken++;

            for(int dependentCourse : adj.get(currentCourse)){
                inDegree[dependentCourse]--;

                if(inDegree[dependentCourse]==0) q.offer(dependentCourse);
            }
        }
        return courseTaken == numCourses;
    }
}
