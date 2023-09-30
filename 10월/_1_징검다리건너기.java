import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1_징검다리건너기 {
    static boolean[] check;
    static int[] stone;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        check = new boolean[N];
        stone = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        check[0] = true;

        for (int i = 0; i < N - 1; i++) {
            if (check[i]) {
                for (int j = i + 1; (j <= i + K) && (j < N); j++) {
                    if (K >= (j - i) * (1 + Math.abs(stone[j] - stone[i]))) {
                        check[j] = true;
                    }
                }
            }
        }

        System.out.println(check[N - 1] ? "YES" : "NO");
    }
}
