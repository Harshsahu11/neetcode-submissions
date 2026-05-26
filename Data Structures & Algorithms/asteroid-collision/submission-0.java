class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int val : asteroids){
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek()>0 && val<0){
                int top = st.peek();
                if(Math.abs(top)<Math.abs(val)) st.pop();
                else if(Math.abs(top)==Math.abs(val)){
                    st.pop();
                    destroyed = true;
                    break;
                }
                else {
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed) st.push(val);
        }
        int[] ans = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}