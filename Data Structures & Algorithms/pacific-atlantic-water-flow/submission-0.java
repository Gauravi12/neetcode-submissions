class Solution {

    public void dfs(int[][] heights, int r, int c,
                    boolean[][] visited, int prevHeight) {

        if (r < 0 || r >= heights.length ||
            c < 0 || c >= heights[0].length ||
            visited[r][c] ||
            heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        dfs(heights, r - 1, c, visited, heights[r][c]);
        dfs(heights, r + 1, c, visited, heights[r][c]);
        dfs(heights, r, c - 1, visited, heights[r][c]);
        dfs(heights, r, c + 1, visited, heights[r][c]);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> outer = new ArrayList<>();

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // Pacific: top row
        for (int j = 0; j < m; j++) {
            dfs(heights, 0, j, pacific, Integer.MIN_VALUE);
        }

        // Pacific: left column
        for (int i = 0; i < n; i++) {
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);
        }

        // Atlantic: bottom row
        for (int j = 0; j < m; j++) {
            dfs(heights, n - 1, j, atlantic, Integer.MIN_VALUE);
        }

        // Atlantic: right column
        for (int i = 0; i < n; i++) {
            dfs(heights, i, m - 1, atlantic, Integer.MIN_VALUE);
        }

        // Common cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> inner = new ArrayList<>();
                    inner.add(i);
                    inner.add(j);
                    outer.add(inner);
                }
            }
        }

        return outer;
    }
}