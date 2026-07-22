class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int col = board[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<col;c++){
                if(board[r][c]==word.charAt(0)&& dfs(board, r, c, word, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int r, int c, String word, int index){
        if(index==word.length()) return true;
        if(r < 0 || c < 0 || r >= board.length ||
        c >= board[0].length || 
        board[r][c] != word.charAt(index)) return false;

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(board,r+1,c,word,index+1)||
                        dfs(board,r-1,c,word,index+1)||
                        dfs(board,r,c+1,word,index+1)||
                        dfs(board,r,c-1,word,index+1);

        board[r][c]=temp;
        return found;
    }
}
