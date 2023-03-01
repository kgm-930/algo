class Solution {
    private static int[] board;
    private static int answer;

    static int n;

    public static int solution(int N) {
        n = N;
        board = new int[n];

        backTracking(0);

        return answer;
    }

    private static void backTracking(int count) {
        if (count == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[count] = i;

            if (valid(count)) {
                backTracking(count + 1);
            }
        }
    }

    private static boolean valid(int now) {
        for (int j = 0; j < now; j++) {
            if (board[now] == board[j]) {
                return false;
            }

            if (Math.abs(now - j) == Math.abs(board[now] - board[j])) {
                return false;
            }
        }

        return true;
    }
}