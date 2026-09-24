class Solution {
    public boolean dfs(int from,int to,List<List<Integer>> adj,int parent){

        if(from == to) return true;

        for(int num : adj.get(from)){
            if(num != parent){
                if(dfs(num,to,adj,from)) return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int[] ans = new int[2];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=edges.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){

            int from = edges[i][0];
            int to = edges[i][1];

            if(dfs(from,to,adj,-1)){
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
                break;
            }

            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);

        }

        return ans;
    }
}