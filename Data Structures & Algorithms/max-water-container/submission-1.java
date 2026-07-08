class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int left = 0;
        int right=n-1;

        while(left<right){
            int currHeight = Math.min(heights[left],heights[right]);
            int width = right-left;
            int currArea = width*currHeight;

            maxArea = Math.max(currArea,maxArea);
            if(heights[left]<heights[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
