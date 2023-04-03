import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3_평범한배낭 {
    static int[] W;
    static int[] V;
    static int[][] sack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 물건 갯수
        int N = Integer.parseInt(st.nextToken());
        // 무게
        int K = Integer.parseInt(st.nextToken());

        W = new int[N + 1];
        V = new int[N + 1];
        sack = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int nowWeight = 1; nowWeight <= K; nowWeight++) {
            for (int index = 1; index <= N; index++) {
                sack[index][nowWeight] = sack[index - 1][nowWeight];

                if (nowWeight >= W[index]) {
                    sack[index][nowWeight] = Math.max(sack[index - 1][nowWeight], V[index] + sack[index - 1][nowWeight - W[index]]);
                }
            }
        }

        System.out.println(sack[N][K]);
    }
}
