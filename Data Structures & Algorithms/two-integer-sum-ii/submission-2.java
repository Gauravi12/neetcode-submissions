class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0;
        int j = 1;
        while(i < numbers.length-1){
            if(numbers[i] + numbers[j] == target){
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }else{
                j++;
            }
            if(j==numbers.length){
                i++;
                j = i+1;
            }
        }
        return ans;
    }
}
