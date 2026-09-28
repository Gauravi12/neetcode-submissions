class MedianFinder {
    PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> pq2 = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        pq1.add(num);

        if(pq2.peek() == null){
            if(pq1.size() > 1){
                pq2.add(pq1.poll());
            }
            return;
        }
        if(pq1.peek() > pq2.peek()){
            pq2.add(pq1.poll());
        }

        if(Math.abs(pq1.size() - pq2.size()) > 1){
            if(pq1.size() > pq2.size()){
                pq2.add(pq1.poll());
            }else{
                pq1.add(pq2.poll());
            }
        }
    }
    
    public double findMedian() {
        if(pq1.size() > pq2.size()){
            return pq1.peek();
        }

        if(pq2.size() > pq1.size()){
            return pq2.peek();
        }

        return (pq1.peek() + pq2.peek()) / 2.0;
    }
}
