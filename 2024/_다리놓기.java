import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _다리놓기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // N<=M
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = i; j <= M; j++) {
                    if (i == 1) {
                        arr[i][j] = j;
                    } else if (i == j) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i][j - 1] + arr[i - 1][j - 1];
                    }
                }
            }

            System.out.println(arr[N][M]);
        }
    }
}
