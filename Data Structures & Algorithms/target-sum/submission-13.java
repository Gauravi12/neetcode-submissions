class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int range = 0;

        for(int i = 0; i < nums.length; i++){
            range += nums[i];
        }

        int value = range - target;

        if(value < 0 || value % 2 != 0){
            return 0;
        }

        int num = value / 2;

        int n = nums.length;
        int[][] dp = new int[n + 1][num + 1];

        dp[0][0] = 1;

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j]
                             + dp[i - 1][j - nums[i - 1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][num];
    }
}