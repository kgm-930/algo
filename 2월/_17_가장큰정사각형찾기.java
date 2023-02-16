class Solution {
    public int solution(int[][] board) {
        int check = 0;

        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                check += ints[j];
            }
        }

        if (check == 0) {
            return 0;
        }

        int answer = 1;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                int cur = board[i][j];

                if (cur == 0) {
                    continue;
                }

                int min = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]);
                board[i][j] = min + 1;

                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
    }
}