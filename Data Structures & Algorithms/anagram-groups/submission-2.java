class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , Integer> map = new HashMap();
        List<List<String>> last = new ArrayList();
        for(int i=0;i<strs.length;i++){
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String str = new String(s);
            if(!map.containsKey(str)){
                map.put(str,last.size());
                List<String> array = new ArrayList();
                array.add(strs[i]);
                last.add(array);
            }else{
                int j = map.get(str);
                last.get(j).add(strs[i]);
            }
        }
        return last;
    }
}
