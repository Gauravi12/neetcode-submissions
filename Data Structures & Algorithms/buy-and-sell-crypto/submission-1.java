class Solution {
    public int maxProfit(int[] prices) {
        int maxCount = 0;
        int count = 0;
        int minLeft = prices[0];
        
        for(int i=1;i<prices.length;i++){
            minLeft = Math.min(minLeft , prices[i]);
            count = prices[i] - minLeft;
            maxCount = Math.max(maxCount , count);
        }
        return maxCount;
    }
}
