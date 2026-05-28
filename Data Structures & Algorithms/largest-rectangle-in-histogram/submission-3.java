class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 1) return heights[0];
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int j = i;
            int k = i;
            int minj = j;
            int mink = k;
            while(j>=0){
                if(heights[j] < heights[i]){
                    break;
                }
                minj = j;
                j--;
            }
            while(k<heights.length){
                if(heights[k] < heights[i]){
                    break;
                }
                mink = k;
                k++;
            }
            int width = (mink-minj)+1;
            int height = heights[i];
            int area = width * height;
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
