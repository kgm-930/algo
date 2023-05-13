import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13_행렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        getNumber(A, N, M, br);
        getNumber(B, N, M, br);

        if (N < 3 || M < 3) {
            if (checkSame(N, M, A, B)) {
                return;
            }

            System.out.print("0");
            return;
        }

        int answer = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (A[i][j] != B[i][j]) {
                    for (int a = i; a < i + 3; a++) {
                        for (int b = j; b < j + 3; b++) {
                            A[a][b] = (A[a][b] == 0) ? 1 : 0;
                        }
                    }

                    answer++;
                }
            }
        }

        if (checkSame(N, M, A, B)) {
            return;
        }

        System.out.print(answer);
    }

    private static void getNumber(int[][] arr, int N, int M, BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = string.charAt(j) - '0';
            }
        }
    }

    private static boolean checkSame(int n, int m, int[][] a, int[][] b) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    System.out.print("-1");
                    return true;
                }
            }
        }

        return false;
    }
}