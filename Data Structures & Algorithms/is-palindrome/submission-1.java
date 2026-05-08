class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "");
        int left = 0;
        int right = cleaned.length() - 1;
        while(left <= right){
            if(Character.toLowerCase(cleaned.charAt(left)) == Character.toLowerCase(cleaned.charAt(right))){
                left++;
                right--;
            }else{
                return false;
            }
        }
        if(left > right) return true;
        return false;
    }
}
