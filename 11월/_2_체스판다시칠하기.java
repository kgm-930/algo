import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class _2_체스판다시칠하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = string.charAt(j);
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int odd = 0;
                int even = 0;

                for (int a = 0; a < 8; a++) {
                    for (int b = 0; b < 8; b++) {
                        char color = ((a + b) % 2 == 1) ? 'W' : 'B';

                        if (board[i + a][j + b] == color) {
                            odd++;
                        } else {
                            even++;
                        }
                    }
                }

                answer = Math.min(Math.min(odd, even), answer);
            }
        }

        System.out.println(answer);
    }
}
