class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int mid = nums.length/2;
        if(nums[mid] > target){
            for(int i=0;i<mid;i++){
                if(nums[i] == target){
                    index = i;
                }
            }
        }else if(nums[mid] < target){
            for(int i=mid;i<nums.length;i++){
               if(nums[i] == target){
                    index = i;
                } 
            }
        }else{
            index = mid;
        }
        return index;
    }
}
