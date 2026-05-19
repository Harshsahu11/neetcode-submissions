class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startrow=0;
        int startcol=0;
        int endrow=matrix.length-1;
        int endcol=matrix[0].length-1;

        List<Integer> res=new ArrayList<>();
        while(startrow<=endrow && startcol<=endcol){
            //top
            for(int j=startcol;j<=endcol;j++){
                res.add(matrix[startrow][j]);
            }
            //right
            for(int j=startrow+1;j<=endrow;j++){
                res.add(matrix[j][endcol]);
            }
            //bottom
            if(startrow<endrow){
                for(int j=endcol-1;j>=startcol;j--){
                res.add(matrix[endrow][j]);
                }
            }
            //left
           if (startcol < endcol) {
                for (int i = endrow - 1; i > startrow; i--) {
                    res.add(matrix[i][startcol]);
                }
            }
            startrow++;
            endrow--;
            startcol++;
            endcol--;
        }
        return res;
    }
}
