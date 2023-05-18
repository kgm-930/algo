import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _18_부녀회장이될테야 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apt = new int[k + 1][n];

            for (int j = 0; j < n; j++) {
                apt[0][j] = j + 1;
            }

            for (int a = 1; a <= k; a++) {
                for (int b = 0; b < n; b++) {
                    for (int c = 0; c <= b; c++) {
                        apt[a][b] += apt[a - 1][c];
                    }
                }
            }

            System.out.println(apt[k][n - 1]);
        }
    }
}
