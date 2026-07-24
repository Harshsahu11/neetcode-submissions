class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Capture all "safe" regions connected to the borders
        // Check first and last column
        for(int r=0;r<rows;r++){
            if(board[r][0]=='O') dfs(board,r,0);
            if(board[r][cols-1]=='O') dfs(board,r,cols-1);
        }
        // Check first and last row
        for(int c=0;c<cols;c++){
            if(board[0][c]=='O') dfs(board,0,c);
            if(board[rows-1][c]=='O') dfs(board,rows-1,c);
        }
        // Step 2: Sweep the board for the final cleanup
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='O') board[r][c] = 'X';
                else if(board[r][c]=='T') board[r][c] = 'O';
            }
        }
    }
    private void dfs(char[][] board,int r,int c){
        if(r<0 ||c<0 ||r>=board.length||c>=board[0].length||board[r][c]!='O') return;
        board[r][c] = 'T';
        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }
}
