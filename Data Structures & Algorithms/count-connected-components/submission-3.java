class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int componentCount = n;
        for (int[] edge : edges) {
            int rootA = find(parent, edge[0]);
            int rootB = find(parent, edge[1]);
            if (rootA != rootB) {
                parent[rootA] = rootB; 
                componentCount--;      
            }
        }
        return componentCount;
    }
    private int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent, parent[node]);
    }
}