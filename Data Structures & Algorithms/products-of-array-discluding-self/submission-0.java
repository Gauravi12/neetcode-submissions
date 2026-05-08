class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i = 0;
        int j = 0;
        int mul = 1;
        int[] arr = new int[nums.length];
        while(j < nums.length){
            if(i==j){
                i++;
            }else{
                mul = mul * nums[i];
                i++;
            }

            if(i == nums.length){
                arr[j] = mul;
                j++;
                i = 0;
                mul = 1;
            }
        }
        return arr;
    }
}  
