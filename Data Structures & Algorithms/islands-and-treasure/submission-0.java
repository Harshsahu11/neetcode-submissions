class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid==null || grid.length==0) return;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        //storing all Treasure Chest
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==0) q.offer(new int[]{r,c});
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir : directions){
                int nextRow = r+dir[0];
                int nextCol = c+dir[1];

                if(nextRow<0 || nextCol<0 || nextRow>=rows ||
                    nextCol>=cols || grid[nextRow][nextCol]!=Integer.MAX_VALUE)
                    continue;

                grid[nextRow][nextCol] = grid[r][c]+1;
                q.offer(new int[]{nextRow,nextCol});
            }
        }
    }
}
