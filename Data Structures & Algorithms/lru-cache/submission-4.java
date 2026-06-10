class LRUCache {
    Map<Integer,Integer> map;
    LinkedList<Integer> list;
    int len;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        list = new LinkedList<>();
        len = capacity;
    }
    
    public int get(int key) {
        int ans = map.getOrDefault(key,-1);
        if(ans != -1){
            list.remove(Integer.valueOf(key));
            list.add(key);
        }
        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            list.remove(Integer.valueOf(key));
        }
        map.put(key , value);
        list.add(key);
        if(map.size() > len){
            int first = list.removeFirst();
            map.remove(first);
        }
    }
}
