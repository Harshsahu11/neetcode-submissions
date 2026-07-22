class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int islands = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]=='1'){
                    islands++;
                    sinkIslandsDFS(grid,r,c);
                }
            }
        }
        return islands;
    }
    private void sinkIslandsDFS(char[][] grid,int r,int c){
        int rows = grid.length;
        int cols = grid[0].length;

        if(r<0 ||c<0 || r>=rows||c>=cols||grid[r][c]=='0') return;
        grid[r][c]='0';

        //all Direction check
        sinkIslandsDFS(grid,r+1,c);
        sinkIslandsDFS(grid,r-1,c);
        sinkIslandsDFS(grid,r,c+1);
        sinkIslandsDFS(grid,r,c-1);
    }
}
