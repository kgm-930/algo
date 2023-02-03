import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        visit[0][0] = true;

        int[] ini = {0, 0, 1};

        queue.offer(ini);

        while (!queue.isEmpty()) {
            int[] info = queue.poll();

            int playerX = info[0];
            int playerY = info[1];
            int count = info[2];

            if ((playerX == n - 1) && (playerY == m - 1)) {
                if (count == Integer.MAX_VALUE) {
                    return -1;
                }

                return count;
            }

            for (int i = 0; i < 4; i++) {
                int newX = playerX + dir[i][0];
                int newY = playerY + dir[i][1];

                if (!((newX >= 0) && (newX < maps.length) && (newY >= 0) && (newY < maps[0].length))) {
                    continue;
                }

                if ((maps[newX][newY] == 1) && !(visit[newX][newY])) {
                    visit[playerX][playerY] = true;
                    int[] newInfo = {newX, newY, count + 1};
                    queue.offer(newInfo);
                }
            }
        }

        return -1;
    }
}