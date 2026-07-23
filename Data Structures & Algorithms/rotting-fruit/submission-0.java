class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Find all initial rotten oranges and count all fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Step 2: Multi-Source BFS to spread the rot layer by layer
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedAny = false;
            
            // Process the current "minute" (all oranges currently in the queue)
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                
                // Try to spread rot in all 4 directions
                for (int[] dir : directions) {
                    int nextRow = r + dir[0];
                    int nextCol = c + dir[1];
                    
                    // If neighbor is within bounds AND is a fresh orange
                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2; // Rot it instantly
                        freshCount--;
                        queue.offer(new int[]{nextRow, nextCol});
                        rottedAny = true;
                    }
                }
            }
            
            // If we successfully rotted at least one orange this round, a minute has passed
            if (rottedAny) {
                minutes++;
            }
        }
        
        // Step 3: Check if any fresh oranges survived
        return freshCount == 0 ? minutes : -1;
    }
}