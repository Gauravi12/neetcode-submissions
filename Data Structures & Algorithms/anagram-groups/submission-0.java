class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>(Arrays.asList(strs[i])));
            }else{
                map.get(str).add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> group : map.values()){
            result.add(group);
        }
        return result;
    }
}
