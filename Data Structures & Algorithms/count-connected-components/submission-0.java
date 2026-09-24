class Solution {

    public void dfs(int course,boolean[] global,List<List<Integer>> adj){
        if(global[course]) return;
        global[course] = true;
        for(int num : adj.get(course)){
            dfs(num,global,adj);
        }
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int index = edges[i][0];
            int toAdd = edges[i][1];
            adj.get(index).add(toAdd);
            adj.get(toAdd).add(index);
        }

        boolean[] global = new boolean[n];
        int count = 0;
        int t = 0;

        for(int i=0;i<n;i++){
            dfs(i,global,adj);
            int tt = 0;
            for(boolean gl : global){
                if(gl){
                    tt++;
                }
            }
            if(tt > t){
                t = tt;
                count++;
            }
        }

        return count;
    }
}
