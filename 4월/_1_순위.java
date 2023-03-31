class Solution {
    static int[][] scoreBoard;

    public int solution(int n, int[][] results) {
        scoreBoard = new int[n][n];

        for (int[] result : results) {
            scoreBoard[result[0] - 1][result[1] - 1] = 1;
            scoreBoard[result[1] - 1][result[0] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (scoreBoard[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        scoreBoard[i][k] = (scoreBoard[j][k] == 1) ? 1 : scoreBoard[i][k];
                        scoreBoard[k][i] = scoreBoard[i][k] * -1;
                    }
                } else if (scoreBoard[i][j] == -1) {
                    for (int k = 0; k < n; k++) {
                        scoreBoard[j][k] = (scoreBoard[i][k] == 1) ? 1 : scoreBoard[j][k];
                        scoreBoard[k][j] = scoreBoard[j][k] * -1;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (scoreBoard[i][j] == 0) {
                    count++;
                }
            }

            if (count == 1) {
                answer++;
            }
        }

        return answer;
    }
}