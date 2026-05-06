class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[k];
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }for(int i=0;i<k;i++){
            int max_key = -1;
            int max = Integer.MIN_VALUE;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if(max<entry.getValue()){
                    max = entry.getValue();
                    max_key =  entry.getKey();
                }
                result[i] = max_key;
            }
            map.remove(max_key);
        }
        return result;
    }
}
