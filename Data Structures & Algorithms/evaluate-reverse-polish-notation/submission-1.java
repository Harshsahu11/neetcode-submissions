class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") ||token.equals("-") || token.equals("*") || token.equals("/")){
                int right = st.pop();
                int left = st.pop();

                if(token.equals("+")) st.push(left+right);
                else if(token.equals("-")) st.push(left-right);
                else if(token.equals("*")) st.push(left*right);
                else st.push(left/right);
            }
            else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
