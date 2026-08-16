class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }else{
            int mid = sum/2;
            boolean[] dp = new boolean[mid+1];
            dp[0] = true;

            for(int i=0;i<nums.length;i++){
                for(int j=mid;j>=nums[i];j--){
                    if(dp[j - nums[i]]){
                        dp[j] = true;
                    }
                }
                if(dp[mid] == true){
                    return true;
                }
            }

        }
        return false;
    }
}
