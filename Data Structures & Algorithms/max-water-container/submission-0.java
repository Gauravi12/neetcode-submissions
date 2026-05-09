class Solution {
    public int maxArea(int[] heights) {

        int maxCount = 0;
        int i = 0;
        int j = heights.length-1;
        int count = 0;

        while(i<j){
            if(heights[i] < heights[j]){
                count = heights[i] * (j-i);
                i++;
            }else{
                count = heights[j] * (j-i);
                j--;
            }
            
            maxCount = Math.max(count , maxCount);
        }
        return maxCount;
    }
}
