class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> str_s = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            str_s.put(ch,str_s.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(!str_s.containsKey(ch)) return false;

            str_s.put(ch,str_s.get(ch)-1);
            if(str_s.get(ch) < 0) return false;
        }
        return true;
    }
}
