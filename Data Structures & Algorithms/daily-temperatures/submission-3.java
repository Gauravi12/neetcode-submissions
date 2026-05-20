class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];
        int i=0;
        int j=0;

        while(j<temperatures.length){
            st.push(temperatures[j]);
            if(temperatures[j] > temperatures[i]){
                result[i] = st.size()-1;
                st.clear();
                i++;
                j=i;
            }else{
                j++;
            }
            if(j==temperatures.length){
                st.clear();
                i++;
                j=i;
            }
        }
        return result;
    }
}
