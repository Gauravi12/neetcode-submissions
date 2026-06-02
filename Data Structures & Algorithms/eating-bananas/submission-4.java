class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : piles){
            if(num > max){
                max = num;
            }
        }

        if(piles.length == h){
            return max;
        }else{
            int start = 1;
            int end = max;
            while(end >= start){
                int mid = (start + end)/2;
                int count = 0;
                for(int num : piles){
                    count = count + (int)Math.ceil((double)num/mid);
                }
                if(count <= h){
                    min = Math.min(min , mid);
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return min;
    }
}
