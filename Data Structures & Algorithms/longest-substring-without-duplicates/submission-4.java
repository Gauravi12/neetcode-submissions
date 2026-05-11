class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;
        int maxCount = 0;
        int j = 0;
        int count = 1;
        for(int i=1;i<s.length();i++){
            while(s.substring(j, i).contains(String.valueOf(s.charAt(i)))){
                j++;
            }
            count = i-j+1;
            maxCount = Math.max(maxCount , count);
        }
        return maxCount;
    }
}
