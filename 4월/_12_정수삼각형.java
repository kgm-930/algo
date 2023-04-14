import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12_정수삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    array[i][0] += array[i - 1][0];
                    continue;
                }

                array[i][j] += Math.max(array[i - 1][j - 1], array[i - 1][j]);
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, array[n - 1][i]);
        }

        System.out.println(max);
    }
}
