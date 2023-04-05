import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coinCase = new int[n + 1];
        int[] able = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            coinCase[i] = Integer.parseInt(st.nextToken());
        }

        for (int coinIndex = 1; coinIndex <= n; coinIndex++) {
            for (int nowValue = 1; nowValue <= k; nowValue++) {
                int coin = coinCase[coinIndex];

                if (coin == nowValue) {
                    able[nowValue]++;
                    continue;
                }

                if (coin < nowValue) {
                    able[nowValue] += able[nowValue - coin];
                }
            }
        }

        System.out.println(able[k]);
    }
}
