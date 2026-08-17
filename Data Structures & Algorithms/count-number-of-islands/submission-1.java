class Solution {

    public void check(int i , int j , char[][] grid , boolean[][] vis , int n , int m){

        if(i<0 || j<0 || i >= n || j>= m || grid[i][j] == '0' || vis[i][j] ) return;

        vis[i][j] = true;

        check(i+1 , j , grid , vis , n , m);
        check(i-1 , j , grid , vis , n , m);
        check(i , j+1 , grid , vis , n , m);
        check(i , j-1 , grid , vis , n , m);

    }

    public int numIslands(char[][] grid) {

        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    check(i , j , grid , vis , n , m);
                }
            }
        }

        return count;
    }
}