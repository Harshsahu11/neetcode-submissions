class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int curr = temperatures[i];
            while(!st.isEmpty() && curr>temperatures[st.peek()]){
                int pre = st.pop();
                result[pre] = i-pre;
            }
            st.push(i);
        }
        return result;
    }
}
