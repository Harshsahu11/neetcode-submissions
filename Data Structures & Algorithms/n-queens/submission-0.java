class Solution {
    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> posDiagSet = new HashSet<>(); // r + c
    private Set<Integer> negDiagSet = new HashSet<>(); // r - c

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize an empty board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, n, board, result);
        return result;
    }
    
    private void backtrack(int r, int n, char[][] board, List<List<String>> result) {
        // Base case: If we've successfully placed a queen in every row
        if (r == n) {
            result.add(constructBoard(board));
            return;
        }
        
        for (int c = 0; c < n; c++) {
            int posDiag = r + c;
            int negDiag = r - c;
            // Check if the current square is under attack
            if (colSet.contains(c) || posDiagSet.contains(posDiag) || negDiagSet.contains(negDiag)) {
                continue;
            }
            // 1. Choose: Place the queen and mark vectors as attacked
            colSet.add(c);
            posDiagSet.add(posDiag);
            negDiagSet.add(negDiag);
            board[r][c] = 'Q';
            
            // 2. Explore: Move to the next row
            backtrack(r + 1, n, board, result);
            
            // 3. Un-choose (Backtrack): Remove the queen and unmark vectors
            colSet.remove(c);
            posDiagSet.remove(posDiag);
            negDiagSet.remove(negDiag);
            board[r][c] = '.';
        }
    }
    
    private List<String> constructBoard(char[][] board) {
        List<String> validBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            validBoard.add(new String(board[i]));
        }
        return validBoard;
    }
}