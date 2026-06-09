class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(fast != nums.length){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        int start = nums[0];
        while(start != slow){
            slow = nums[slow];
            start = nums[start];
        }

        return slow;
    }
}
