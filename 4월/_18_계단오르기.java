import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _18_계단오르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] floor = new int[n + 1];
        int[][] sum = new int[2][n + 1];

        for (int i = 1; i <= n; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sum[0][i] = floor[i];
                continue;
            } else if (i == 2) {
                sum[0][i] = floor[i];
                sum[1][i] = sum[0][i - 1] + floor[i];
                continue;
            }

            sum[0][i] = Math.max(sum[0][i - 2], sum[1][i - 2]) + floor[i];
            sum[1][i] = sum[0][i - 1] + floor[i];

        }

        System.out.println(Math.max(sum[0][n], sum[1][n]));
    }
}
