class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        int x;
        int y;

        while(!pq.isEmpty()){

            if(pq.peek() == null) return 0;
            x = pq.poll();
            if(pq.peek() == null) return x;
            y = pq.poll();

            if(x>y){
                pq.add(x-y);
            }
            if(y>x){
                pq.add(y-x);
            }
        }
        return 0;
    }
}
