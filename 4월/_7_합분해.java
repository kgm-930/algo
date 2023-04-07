import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7_합분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] value = new long[K + 1][N + 1];
        Arrays.fill(value[1], 1);

        for (int i = 2; i <= K; i++) {
            for (int nowValue = 0; nowValue <= N; nowValue++) {
                if (nowValue == 0) {
                    value[i][nowValue] = 1;
                    continue;
                }

                long sum = 0;

                for (int preValue = 0; preValue <= nowValue; preValue++) {
                    sum += value[i - 1][preValue];
                }

                value[i][nowValue] = sum % 1000000000;
            }
        }

        System.out.println(value[K][N] % 1000000000);
    }
}
