import java.util.Collections;
import java.util.LinkedList;

class Solution {
    int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    LinkedList<Integer> answer = new LinkedList<>();
    int sum = 0;
    int[][] map;

    public Object[] solution(String[] maps) {
        int x = maps.length;
        int y = maps[0].length();

        map = new int[x][y];


        for (int i = 0; i < x; i++) {
            String string = maps[i];

            for (int j = 0; j < y; j++) {
                if (string.charAt(j) != 'X') {
                    map[i][j] = string.charAt(j) - '0';
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                sum = 0;

                getArea(i, j);

                if (sum != 0) {
                    answer.add(sum);
                }
            }
        }

        Collections.sort(answer);

        if (answer.isEmpty()) {
            answer.add(-1);
        }

        return answer.toArray();
    }

    private void getArea(int x, int y) {
        sum += map[x][y];
        map[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if ((nextX >= 0) && (nextX < map.length) && (nextY >= 0) && (nextY < map[0].length)) {
                if (map[nextX][nextY] != 0) {
                    getArea(nextX, nextY);
                }
            }
        }
    }
}