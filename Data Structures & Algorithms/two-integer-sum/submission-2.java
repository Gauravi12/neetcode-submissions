class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer , Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i] , i);
            }
        }

        for(int i=0;i<nums.length;i++){
            int sub = target - nums[i];
            if(map.containsKey(sub)){
                ans[0] = map.get(sub);
                ans[1] = i;
            }
        }
        return ans;
    }
}
