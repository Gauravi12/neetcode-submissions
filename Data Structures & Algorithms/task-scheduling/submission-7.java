class Solution { 
    public int leastInterval(char[] tasks, int n) { 
        if(n == 0) return tasks.length; 

        ArrayList<Character> list = new ArrayList<>(); 
        HashMap<Character,Integer> map = new HashMap<>(); 

        for(int i = 0; i < tasks.length; i++){ 
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1); 
        } 

        int posi = 0; 

        while(map.size() > 0){ 
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b) -> b[1] - a[1]
            );

            for(Map.Entry<Character,Integer> entry : map.entrySet()){ 
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            }

            posi = list.size(); 

            int min = Math.min(pq.size(), n + 1); 

            for(int i = 0; i < min; i++){ 
                int[] cur = pq.poll();
                char ch = (char)cur[0];
                list.add(ch); 
                map.put(ch, map.get(ch) - 1); 
                if(map.get(ch) == 0){ 
                    map.remove(ch); 
                } 
            }

            while(map.size() > 0 && list.size() - posi < n + 1){ 
                list.add('a'); 
            } 
        } 

        return list.size(); 
    } 
}