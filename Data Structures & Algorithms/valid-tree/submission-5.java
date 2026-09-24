class Solution {
    public boolean dfs(int course,List<List<Integer>> adj,boolean[] path,int parent){
        if(path[course]) return false;
        path[course] = true;
        for(int num : adj.get(course)){
            if(num != parent){
                if(!dfs(num,adj,path,course)) return false;
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
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

        boolean[] path = new boolean[n];
        if (!dfs(0, adj, path, -1)) return false;
        for(boolean pa : path){
            if(!pa) return false;
        }
        return true;
    }
}
