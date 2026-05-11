class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        HashMap<Character , Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int maxCount = 0; 
        int count = 0;

        while(j<s.length()){
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j) , 1);
                count++;
                j++;
            }else{
                map.remove(s.charAt(i));
                i++;
                count--;
            }
            maxCount = Math.max(maxCount , count);
        }
        return maxCount;
    }
}
