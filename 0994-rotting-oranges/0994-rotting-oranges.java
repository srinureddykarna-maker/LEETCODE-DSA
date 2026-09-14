class Solution {
    public int orangesRotting(int[][] grid) {

        int minutes = 0;
        int fresh = 0;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        // Put all rotten oranges into queue
        // Count fresh oranges
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
                else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                for (int[] d : dir) {

                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];

                    if (x >= 0 && x < m &&
                        y >= 0 && y < n &&
                        grid[x][y] == 1) {

                        grid[x][y] = 2;
                        fresh--;

                        q.offer(new int[]{x, y});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes - 1 : -1;
    }
}
