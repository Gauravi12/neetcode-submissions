class Solution {
    public boolean dfs(int course,int[] global,List<List<Integer>> adj,boolean[] path){

        if(global[course] == 1){
            return true;
        }

        if(path[course]){
            return false;
        }

        path[course] = true;

        for(int prerequisite : adj.get(course)){
            if(!dfs(prerequisite,global,adj,path)){
                return false;
            }
        }
        path[course] = false;
        global[course] = 1;
        return true;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int index = prerequisites[i][0];
            int toAdd = prerequisites[i][1];
            adj.get(index).add(toAdd);
        }
        
        int[] global = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            boolean[] path = new boolean[numCourses];
            if(!dfs(i,global,adj,path)){
                return false;
            }
        }
        return true;
    }
}
