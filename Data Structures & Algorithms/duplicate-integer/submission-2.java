class Solution {
    public boolean hasDuplicate(int[] nums) {
        int sizeA = nums.length;
        HashSet<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        int sizeS = set.size();
        if(sizeA != sizeS) return true;
        return false;
    }
}