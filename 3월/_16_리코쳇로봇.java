class Solution {
    static int[][] map;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[] goal = new int[2];
    static int check = -1;

    public int solution(String[] board) {
        map = new int[board.length][board[0].length()];
        int[] botXY = new int[2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                char area = board[i].charAt(j);

                switch (area) {
                    case '.':
                        map[i][j] = Integer.MAX_VALUE;
                        break;

                    case 'R':
                        map[i][j] = Integer.MAX_VALUE;
                        botXY[0] = i;
                        botXY[1] = j;
                        break;

                    case 'D':
                        map[i][j] = 0;
                        break;

                    case 'G':
                        map[i][j] = Integer.MAX_VALUE;
                        goal[0] = i;
                        goal[1] = j;
                        break;
                }
            }
        }

        botAction(botXY[0], botXY[1], 1);

        if(map[goal[0]][goal[1]] == Integer.MAX_VALUE){
            return -1;
        }else{
            return map[goal[0]][goal[1]];
        }
    }

    private void botAction(int X, int Y, int count) {
        if (check != -1) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = X + dir[i][0];
            int nextY = Y + dir[i][1];

            while ((nextX >= 0) && (nextX < map.length) && (nextY >= 0) && (nextY < map[0].length)) {
                if (map[nextX][nextY] == 0) {
                    break;
                }

                nextX += dir[i][0];
                nextY += dir[i][1];
            }

            nextX -= dir[i][0];
            nextY -= dir[i][1];

            if (count >= map[nextX][nextY]) {
                continue;
            }

            map[nextX][nextY] = count;

            if ((nextX == goal[0]) && (nextY == goal[1])) {
                check = Math.min(count, check);
            } else {
                botAction(nextX, nextY, count + 1);
            }
        }
    }
}