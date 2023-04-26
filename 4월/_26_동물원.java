import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _26_동물원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[3][N];

        arr[0][0] = arr[1][0] = arr[2][0] = 1;

        if (N > 1) {
            arr[0][1] = arr[0][0] + arr[1][0] + arr[2][0];
            arr[1][1] = arr[2][1] = 2;
        }

        for (int i = 2; i < N; i++) {
            arr[0][i] = (arr[0][i - 1] + arr[1][i - 1] + arr[2][i - 1]) % 9901;
            arr[1][i] = (arr[0][i - 1] + arr[2][i - 1]) % 9901;
            arr[2][i] = (arr[0][i - 1] + arr[1][i - 1]) % 9901;
        }

        System.out.println((arr[0][N - 1] + arr[1][N - 1] + arr[2][N - 1]) % 9901);
    }
}
