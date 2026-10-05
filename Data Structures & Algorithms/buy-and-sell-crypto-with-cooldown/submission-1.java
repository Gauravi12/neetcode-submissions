class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int index=prices.length-1;index>=0;index--){
            //can do buy
            dp[index][1] = Math.max(-prices[index] + dp[index+1][0] , dp[index+1][1]);
            //can't do buy 
            dp[index][0] = Math.max(prices[index] + dp[index+2][1] , dp[index+1][0]);
        }

        return dp[0][1];

    }
}
