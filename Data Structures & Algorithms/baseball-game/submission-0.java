class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String ch : operations){
            if(ch.equals("+")){
                int top = st.pop();
                int newTop = top + st.peek();
                st.push(top);
                st.push(newTop);
            }
            else if(ch.equals("D")){
                st.push(2 * st.peek());
            }
            else if(ch.equals("C")){
                st.pop();
            }
            else{
                st.push(Integer.parseInt(ch));
            }
        }

        int sum = 0;
        for(int num : st){
            sum += num;
        }

        return sum;
    }
}