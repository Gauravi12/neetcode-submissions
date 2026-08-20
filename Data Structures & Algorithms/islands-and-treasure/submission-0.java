class Solution {

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];

            if(i-1 >= 0 && grid[i-1][j] == 2147483647) {
                grid[i-1][j] = grid[i][j] + 1;
                q.offer(new int[]{i-1,j});
            }

            if(i+1 < n && grid[i+1][j] == 2147483647) {
                grid[i+1][j] = grid[i][j] + 1;
                q.offer(new int[]{i+1,j});
            }

            if(j-1 >= 0 && grid[i][j-1] == 2147483647) {
                grid[i][j-1] = grid[i][j] + 1;
                q.offer(new int[]{i,j-1});
            }

            if(j+1 < m && grid[i][j+1] == 2147483647) {
                grid[i][j+1] = grid[i][j] + 1;
                q.offer(new int[]{i,j+1});
            }
        }
    }
}
