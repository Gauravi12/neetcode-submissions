class Solution {

    public int circular(int[] nums , int start , int end){
        if(nums.length == 1) return nums[0];
        int n = end - start;
        int[] dp = new int[n];

        dp[0] = nums[start];
        if (n > 1){
            dp[1] = Math.max(nums[start], nums[start + 1]);
        }

        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2] + nums[start + i]);
        }

        return dp[n-1];
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(circular(nums , 0 , nums.length-1) , circular(nums , 1 , nums.length));
    }
}
