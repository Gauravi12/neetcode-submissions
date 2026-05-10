class Solution {
    public int trap(int[] height) {
        int count = 0;
        
        for(int i=1;i<height.length-1;i++){
            int leftMax = height[i];
            int leftCount = 0;
            int j = i;
            while(j>0){
                if(height[j-1] > height[j]){
                    j = j-1;
                    leftCount = height[j];
                }else{
                    j--;
                }
                leftMax = Math.max(leftMax,leftCount);
            }
            int rightMax =  height[i];
            int rightCount = 0;
            int k = i;
            while(k<height.length-1){
                if(height[k+1] > height[k]){
                    k = k+1;
                    rightCount = height[k];
                }else{
                    k++;
                }
                rightMax = Math.max(rightMax,rightCount);
            }

            count = count + (Math.min(leftMax , rightMax) - height[i]);
        }
        return count;
    }
}
