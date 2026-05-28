class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!st.empty() && heights[i] < heights[st.peek()]){
                int height = heights[st.pop()];
                int nsm = i;
                int psm = st.empty()?-1:st.peek();
                int area = height * (nsm-psm-1);
                maxArea = Math.max(area,maxArea);
            }
            st.push(i);
        }
        while(!st.empty()){
            int height = heights[st.pop()];
            int nsm = heights.length;
            int psm = st.empty()?-1:st.peek();
            int area = height * (nsm-psm-1);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
