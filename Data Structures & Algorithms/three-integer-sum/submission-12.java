class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int k = i+1;
        int j = nums.length - 1;
        if(nums.length < 3) return null;
        if(nums.length == 3){
            if(nums[i] + nums[k] + nums[j] == 0){
                List<Integer> subAns = new ArrayList<>();
                subAns.add(nums[i]);
                subAns.add(nums[k]);
                subAns.add(nums[j]);
                ans.add(subAns);
            }
            return ans;
        }

        while(i < nums.length-2){
            if(nums[i] + nums[k] + nums[j] == 0){
                List<Integer> subAns = new ArrayList<>();
                subAns.add(nums[i]);
                subAns.add(nums[k]);
                subAns.add(nums[j]);
                ans.add(subAns);
                k++;
                j--;
                while(nums[k] == nums[k-1] && nums[j] == nums[j+1] && k<j){
                    k++;
                    j--;
                }
            }else if (nums[i] + nums[k] + nums[j] > 0){
                j--;
                while(nums[j] == nums[j+1] && k<j){
                    j--;
                }
            }else{
                k++;
                while(nums[k] == nums[k-1] && k<j){
                    k++;
                }
            }
            if(k>=j){
                i++;
                k = i+1;
                j = nums.length - 1;
                while(nums[i] == nums[i-1] && i < nums.length-2){
                    i++;
                    k = i+1;
                    j = nums.length - 1;   
                }
            }
        }
        return ans;
    }
}
