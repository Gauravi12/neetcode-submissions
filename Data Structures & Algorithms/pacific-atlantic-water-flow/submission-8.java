class Solution {

    public void dfs(int[][] heights, boolean[][] ocean, int i, int j) {

        // Already visited
        if (ocean[i][j]) {
            return;
        }

        ocean[i][j] = true;

        int[][] directions = {
            {-1, 0},   // up
            {1, 0},    // down
            {0, -1},   // left
            {0, 1}     // right
        };

        for (int[] d : directions) {

            int ni = i + d[0];
            int nj = j + d[1];

            // Check boundary
            if (ni < 0 || ni >= heights.length ||
                nj < 0 || nj >= heights[0].length) {
                continue;
            }

            // Reverse water flow:
            // next cell must be >= current cell
            if (heights[ni][nj] >= heights[i][j]) {
                dfs(heights, ocean, ni, nj);
            }
        }
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];


        // ---------------- PACIFIC ----------------

        // TOP row
        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j);
        }

        // LEFT column
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0);
        }


        // ---------------- ATLANTIC ----------------

        // BOTTOM row
        for (int j = 0; j < m; j++) {
            dfs(heights, atlantic, n - 1, j);
        }

        // RIGHT column
        for (int i = 0; i < n; i++) {
            dfs(heights, atlantic, i, m - 1);
        }


        // ---------------- ANSWER ----------------

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    answer.add(Arrays.asList(i, j));
                }
            }
        }

        return answer;
    }
}