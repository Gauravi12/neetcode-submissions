class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int maxCount = 1;
        for(int num : nums){
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : set){
            list.add(num);
        }
        Collections.sort(list);
        int i=0;
        int j=1;
        int count = 1;
        while(j<list.size()){
            if(list.get(j) == list.get(i) + 1){
                count++;
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
