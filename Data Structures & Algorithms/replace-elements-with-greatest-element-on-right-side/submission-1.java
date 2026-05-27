class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int maxEle = arr[n-1];
        ans[n-1] = -1;
        for(int i = n-2;i>=0;i--){
            if(arr[i]>maxEle){
                ans[i] = maxEle;
                maxEle = arr[i];
            }else ans[i] = maxEle;
        }
        return ans;
    }
}