import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6_동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coinCase = new int[n + 1];
        int[] value = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            coinCase[i] = Integer.parseInt(br.readLine());
        }

        for (int nowCoin = 1; nowCoin <= n; nowCoin++) {
            for (int nowValue = 1; nowValue <= k; nowValue++) {
                int coin = coinCase[nowCoin];
                if (coin == nowValue) {
                    value[nowValue] = 1;
                } else if (coin < nowValue) {
                    if (value[nowValue] == 0) {
                        if (value[nowValue - coin] != 0) {
                            value[nowValue] = value[nowValue - coin] + 1;
                        }
                    } else {
                        if (value[nowValue - coin] != 0) {
                            value[nowValue] = Math.min(value[nowValue], value[nowValue - coin] + 1);
                        }
                    }
                }
            }
        }

        if (value[k] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(value[k]);
        }
    }
}
