class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String nums : tokens){
            if(nums.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(a+b);
            }else if(nums.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            }else if(nums.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }else if(nums.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a*b);
            }else{
                st.push(Integer.parseInt(nums));
            }
        }
        return st.pop();
    }
}
