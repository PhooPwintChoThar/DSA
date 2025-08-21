package Lab06;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_671755 {
    public int maxLandArea(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = bfs(grid, visited, r, c);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, boolean[][] visited, int startR, int startC) {
        int[] dr = {-1, 1, 0, 0}; // up, down
        int[] dc = {0, 0, -1, 1}; // left, right

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int r = cell[0];
            int c = cell[1];
            count++;

            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isValid(grid, visited, nr, nc)) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return count;
    }

    private boolean isValid(int[][] grid, boolean[][] visited, int r, int c) {
        return r >= 0 && r < grid.length &&
               c >= 0 && c < grid[0].length &&
               grid[r][c] == 1 && !visited[r][c];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0},
            {1, 0, 0, 1},
            {0, 0, 1, 1},
            {1, 1, 0, 0}
        };

        Solution_671755 s = new Solution_671755();
        int result = s.maxLandArea(grid);
        System.out.println("Largest land area: " + result);
    }
}
