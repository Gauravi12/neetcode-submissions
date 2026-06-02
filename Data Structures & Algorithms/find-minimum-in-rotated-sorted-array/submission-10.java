class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length-1;
        if(nums[start] <= nums[end]){
            return nums[0];
        }else{
            while(end > start){
                int mid = (start+end)/2;
                if(nums[mid] > nums[end]){
                    start = mid + 1;
                }else{
                    end = mid;
                }
                min = Math.min(min , nums[start]);
            }
        }
        return min;
    }
}
