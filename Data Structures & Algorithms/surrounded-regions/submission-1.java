class Solution {
    public void dfs(char[][] board , boolean[][] vis , int i  , int j){
        vis[i][j] = true;

        if(i-1 >= 0){
            if(board[i-1][j] == 'O' && !vis[i-1][j]){
                dfs(board , vis , i-1 , j);
            }
        }
        if(i+1 < board.length){
            if(board[i+1][j] == 'O' && !vis[i+1][j]){
                dfs(board , vis , i+1 , j);
            }
        }
        if(j-1 >= 0){
            if(board[i][j-1] == 'O' && !vis[i][j-1]){
                dfs(board , vis , i , j-1);
            }
        }
        if(j+1 < board[0].length){
            if(board[i][j+1] == 'O' && !vis[i][j+1]){
                dfs(board , vis , i , j+1);
            }
        }

    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        //4 for loop for 4 side
        for(int j=0;j<m;j++){
            if(board[0][j] == 'O'){
                dfs(board , vis , 0 , j);
            }

            if(board[n-1][j] == 'O'){
                dfs(board , vis , n-1 , j);
            }
        }

        for(int i=0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(board , vis , i , 0);
            }
            if(board[i][m-1] == 'O'){
                dfs(board , vis , i , m-1);
            }
        }

        //to check
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
