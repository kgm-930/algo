import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3_숫자정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] square = new int[N][M];

        int answer = 1;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                square[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int A = square[i][j];

                for (int k = j + 1; k < M; k++) {
                    if (square[i][k] == A) {
                        if (i + (k - j) < N) {
                            if ((square[i + (k - j)][j] == square[i + (k - j)][k]) && (square[i + (k - j)][j] == A)) {
                                answer = (int) Math.max(answer, Math.pow(k - j + 1, 2));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
