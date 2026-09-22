class Solution {

    public boolean dfs(int course, List<List<Integer>> adc, int[] global, boolean[] path){

        if(global[course] == 1){
            return true;
        }

        if(path[course]){
            return false;
        }

        path[course] = true;

        for(int prerequisites : adc.get(course)){
            if(!dfs(prerequisites, adc, global, path)){
                return false;
            }
        }

        path[course] = false;
        global[course] = 1;
        return true;

    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1st make the list
        List<List<Integer>> adc = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adc.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int index = prerequisites[i][0];
            adc.get(index).add(prerequisites[i][1]);
        }

        int[] global = new int[numCourses];

        for(int i=0;i<adc.size();i++){
            boolean[] path = new boolean[numCourses];
            if(!dfs(i,adc,global,path)){
                return false;
            }
        }
        return true;
    }
}
