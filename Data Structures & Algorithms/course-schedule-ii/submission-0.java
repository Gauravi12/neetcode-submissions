class Solution {

    public boolean dfs(int course, boolean[] path, int[] global,
                       List<List<Integer>> adj, List<Integer> order) {

        if(global[course] == 1){
            return true;
        }

        if(path[course]){
            return false;
        }

        path[course] = true;

        for(int prerequisite : adj.get(course)){
            if(!dfs(prerequisite, path, global, adj, order)){
                return false;
            }
        }

        path[course] = false;
        global[course] = 1;
        order.add(course);

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int index = prerequisites[i][0];
            int toAdd = prerequisites[i][1];

            adj.get(index).add(toAdd);
        }

        int[] global = new int[numCourses];

        // ONE order for all courses
        List<Integer> order = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){

            boolean[] path = new boolean[numCourses];

            if(!dfs(i, path, global, adj, order)){
                return new int[0];
            }
        }

        int[] ans = new int[order.size()];

        for(int j = 0; j < order.size(); j++){
            ans[j] = order.get(j);
        }

        return ans;
    }
}