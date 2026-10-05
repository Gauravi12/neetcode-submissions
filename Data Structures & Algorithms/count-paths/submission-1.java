class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == m-1){
                    ans[i][j] = 1;
                }

                if(j == n-1){
                    ans[i][j] = 1;
                }
            }
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                ans[i][j] = ans[i][j+1] + ans[i+1][j];
            }
        }

        return ans[0][0];
    }
}
