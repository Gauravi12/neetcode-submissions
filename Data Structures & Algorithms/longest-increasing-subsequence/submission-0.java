class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums.length == 0 || nums.length == 1) return nums.length;

        int[] dp = new int[nums.length];
        Arrays.fill(dp , 1);

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }

        return max;

    }
}
