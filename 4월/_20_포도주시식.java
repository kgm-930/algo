import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _20_포도주시식 {
    static int[] wine;
    static int[] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        wine = new int[n + 1];
        sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        sum[1] = wine[1];

        if (n >= 2) {
            sum[2] = wine[1] + wine[2];
        }

        for (int i = 3; i <= n; i++) {
            sum[i] = Math.max(sum[i - 1], Math.max(sum[i - 2] + wine[i], sum[i - 3] + wine[i - 1] + wine[i]));

        }

        System.out.println(sum[n]);
    }
}
