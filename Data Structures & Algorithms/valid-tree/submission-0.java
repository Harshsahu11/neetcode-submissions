class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;

        int[] parent = new int[n];

        for(int i=0;i<n;i++) parent[i] = i;

        for(int[] edge : edges){
            int rootA = find(parent,edge[0]);
            int rootB = find(parent,edge[1]);
            // If they share the same root, a cycle exists!
            if(rootA==rootB) return false;

            parent[rootA] = rootB;
        }
        return true; 
    }
    private int find(int[] parent,int node){
        if(parent[node]==node) return node;
        return parent[node]=find(parent,parent[node]);
    }
}
