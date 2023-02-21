import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            boolean[][] check = new boolean[n + 1][n + 1];
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < wires.length; j++) {
                if (i == j) {
                    continue;
                }

                check[wires[j][0]][wires[j][1]] = true;
                check[wires[j][1]][wires[j][0]] = true;
            }

            int count = 1;

            queue.add(1);

            while (!queue.isEmpty()) {
                int x = queue.poll();

                for (int y = 1; y <= n; y++) {
                    if (check[x][y]) {
                        check[x][y] = false;
                        check[y][x] = false;
                        queue.add(y);
                        count++;
                    }
                }
            }

            answer = Math.min(answer, Math.abs(Math.abs(n - count) - count));
        }

        return answer;
    }
}