package sheet.sde.stacknqueue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
                if (grid[i][j] == 1) countFresh++;
            }
        }

        if (countFresh == 0) return 0;
        int count = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            ++count;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                    countFresh--;
                }
            }
        }

        return (countFresh == 0) ? count - 1 : -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("Minimum Number of Minutes Required " + (new RottenOrange().orangesRotting(arr)));
    }
}
