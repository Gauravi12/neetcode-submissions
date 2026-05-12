class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character , Integer> map1 = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i) , map1.getOrDefault(s1.charAt(i) , 0) + 1);
        }
        int lenS1 = s1.length();

        int i = 0;
        HashMap<Character , Integer> map2 = new HashMap<>();
        for(int j=0;j<s2.length();j++){
            int num = map1.getOrDefault(s2.charAt(j) , 0);
            if(num == 0){
                i=j+1;
                map2.clear();
            }else{
                map2.put(s2.charAt(j) , map2.getOrDefault(s2.charAt(j) , 0) + 1);
                while(map1.get(s2.charAt(j)) < map2.get(s2.charAt(j))){
                    map2.put(s2.charAt(i) , map2.get(s2.charAt(i)) - 1);
                    if(map2.get(s2.charAt(i)) == 0){
                        map2.remove(s2.charAt(i));
                    }
                    i++;
                }
                if(map1.equals(map2)) return true;
            }
        }
        return false;
    }
}
