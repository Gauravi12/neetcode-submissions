class Solution {
    public int check(int i,int j,int[][]grid,boolean[][]vis, int n,int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == 0 || vis[i][j]){
            return 0;
        }

        vis[i][j] = true;

        return 1 + check(i+1,j,grid,vis,n,m) +
        check(i-1,j,grid,vis,n,m) +
        check(i,j+1,grid,vis,n,m) +
        check(i,j-1,grid,vis,n,m);

    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int count = check(i,j,grid,vis,n,m);
                    maxCount = Math.max(count , maxCount);
                }
            }
        }

        return maxCount;
    }
}
