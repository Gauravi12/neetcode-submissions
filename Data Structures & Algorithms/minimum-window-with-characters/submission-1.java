class Solution {

    public boolean isValid(HashMap<Character , Integer> maps , HashMap<Character , Integer> mapt){
        for(Character c : mapt.keySet()){
            if(maps.getOrDefault(c,0) < mapt.get(c)){
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        HashMap<Character , Integer> mapt = new HashMap<>();
        for(int i=0;i<t.length();i++){
            mapt.put(t.charAt(i) , mapt.getOrDefault(t.charAt(i) , 0) + 1);
        }

        int minI = 0;
        int minJ = 0;
        int i = 0;
        int j = 0;
        int minCount = Integer.MAX_VALUE;
        int count = 0;
        HashMap<Character , Integer> maps = new HashMap<>();

        while(j<s.length()){
            int value = mapt.getOrDefault(s.charAt(j) , 0);
            if(value == 0){
                if(i==j){
                    i++;
                    j++;
                }else{
                    j++;
                }
            }else{
                maps.put(s.charAt(j) , maps.getOrDefault(s.charAt(j),0) + 1);
                j++;
                while(isValid(maps , mapt)){
                    count = j-i;
                    if(count < minCount){
                        minCount = count;
                        minI = i;
                        minJ = j;
                    }

                    if(maps.containsKey(s.charAt(i))){
                        maps.put(s.charAt(i) , maps.get(s.charAt(i)) - 1);
                        if(maps.get(s.charAt(i)) == 0){
                            maps.remove(s.charAt(i));
                        }
                    }
                    i++;
                }
            }
        }
        return s.substring(minI , minJ);
    }
}
