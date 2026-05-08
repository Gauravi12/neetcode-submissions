class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int maxCount = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        Collections.sort(list);
        int i=0;
        int j=1;
        int count = 1;
        while(j<list.size()){
            if(list.get(j) == list.get(i) + 1){
                count++;
            }else if(list.get(j) == list.get(i)){
                
            }else{
                count = 1;
            }
            i = j;
            j++;
            maxCount = Math.max(maxCount , count);
        }
        return maxCount;
    }
}
