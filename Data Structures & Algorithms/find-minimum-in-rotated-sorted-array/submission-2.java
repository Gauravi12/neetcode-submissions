class Solution {
    public int findMin(int[] nums) {
        // int max = Integer.MIN_VALUE;
        // int max_index = 0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i] > max){
        //         max = nums[i];
        //         max_index = i;
        //     }
        // }
        // max_index = max_index + 1;
        // if(max_index == nums.length){
        //     return nums[0];
        // }
        // return nums[max_index];
        Arrays.sort(nums);
        return nums[0];
    }
}
