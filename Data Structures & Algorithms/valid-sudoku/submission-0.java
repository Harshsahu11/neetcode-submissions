class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char currVal = board[i][j];

                if(currVal!='.'){
                    if(!hs.add(currVal+" in row "+i) ||
                       !hs.add(currVal+" in col "+j) ||
                       !hs.add(currVal+" in block "+(i/3)+"-"+(j/3))){
                        return false;
                       }
                }
            }
        }
        return true;

    }
}
