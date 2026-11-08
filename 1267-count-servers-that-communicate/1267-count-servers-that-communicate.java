import java.util.*;

class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                    int size = 0;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();

                        int r = curr[0];
                        int c = curr[1];

                        size++;

                        for (int k = 0; k < n; k++) {
                            if (grid[k][c] == 1 && !visited[k][c]) {
                                visited[k][c] = true;
                                q.offer(new int[]{k, c});
                            }
                        }

                        for (int k = 0; k < m; k++) {
                            if (grid[r][k] == 1 && !visited[r][k]) {
                                visited[r][k] = true;
                                q.offer(new int[]{r, k});
                            }
                        }
                    }

                    if (size > 1) {
                        count += size;
                    }
                }
            }
        }

        return count;
    }
}