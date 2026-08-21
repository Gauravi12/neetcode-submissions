class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        // Put all rotten oranges into queue
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int count = 0;

        while(!q.isEmpty() && fresh > 0) {

            // 🔥 All oranges currently in queue spread
            // during the SAME minute
            int size = q.size();

            for(int k = 0; k < size; k++) {

                int[] curr = q.poll();

                int i = curr[0];
                int j = curr[1];

                // UP
                if(i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    fresh--;
                    q.offer(new int[]{i - 1, j});
                }

                // LEFT
                if(j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    fresh--;
                    q.offer(new int[]{i, j - 1});
                }

                // DOWN
                if(i + 1 < n && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    fresh--;
                    q.offer(new int[]{i + 1, j});
                }

                // RIGHT
                if(j + 1 < m && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    fresh--;
                    q.offer(new int[]{i, j + 1});
                }
            }

            // 🔥 One complete BFS level = one minute
            count++;
        }

        // If fresh oranges are still left, they can never rot
        return fresh == 0 ? count : -1;
    }
}