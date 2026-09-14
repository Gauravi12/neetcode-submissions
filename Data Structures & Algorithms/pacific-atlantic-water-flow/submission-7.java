class Solution {

    public boolean dfs(int[][] heights , boolean[][] sea , int i, int j , boolean[][] visited){
        visited[i][j] = true;
        if(i-1 >= 0){
            if(heights[i-1][j] <= heights[i][j] && sea[i-1][j] == true){
                sea[i][j] = true;
                return true;
            }
            if(heights[i-1][j] <= heights[i][j] && !sea[i-1][j] && !visited[i-1][j]){
                if(dfs(heights , sea , i-1 , j , visited)){
                    sea[i][j] = true;
                    return true;
                }
            }
        }
        if(i+1 < heights.length){
            if(heights[i+1][j] <= heights[i][j] && sea[i+1][j] == true){
                sea[i][j] = true;
                return true;
            }
            if(heights[i+1][j] <= heights[i][j] && !sea[i+1][j] && !visited[i+1][j]){
                if(dfs(heights , sea , i+1 , j , visited)){
                    sea[i][j] = true;
                    return true;
                }
            }
        }
        if(j-1 >= 0){
            if(heights[i][j-1] <= heights[i][j] && sea[i][j-1] == true){
                sea[i][j] = true;
                return true;
            }
            if(heights[i][j-1] <= heights[i][j] && !sea[i][j-1] && !visited[i][j-1]){
                if(dfs(heights , sea , i , j-1 , visited)){
                    sea[i][j] = true;
                    return true;
                }
            }
        }
        if(j+1 < heights[0].length){
            if(heights[i][j+1] <= heights[i][j] && sea[i][j+1] == true){
                sea[i][j] = true;
                return true;
            }

            if(heights[i][j+1] <= heights[i][j] && !sea[i][j+1] && !visited[i][j+1]){
                if(dfs(heights , sea , i , j+1 , visited)){
                    sea[i][j] = true;
                    return true;
                }
            }
        }
        return false;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    pacific[i][j] = true;
                }
                if(i==n-1 || j==m-1){
                    atlantic[i][j] = true;
                }
            }
        }

        //for pacific
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                boolean[][] visited = new boolean[n][m];
                dfs(heights , pacific , i , j , visited);
            }
        }


        //for atlantic
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                boolean[][] visited = new boolean[n][m];
                dfs(heights , atlantic , i , j , visited);
            }
        }

        List<List<Integer>> final1 = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    final1.add(Arrays.asList(i, j));
                }
            }
        }

        return final1;
    }
}