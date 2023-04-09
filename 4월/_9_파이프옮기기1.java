import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9_파이프옮기기1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] checkWall = new int[N + 1][N + 1];
        int[][][] house = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                checkWall[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        house[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if (checkWall[i][j] == 0) {
                    int a = house[i][j - 1][0];
                    int b = house[i][j - 1][2];

                    house[i][j][0] = a + b;
                }

                if (checkWall[i][j] == 0) {
                    int a = house[i - 1][j][1];
                    int b = house[i - 1][j][2];

                    house[i][j][1] = a + b;
                }

                if ((checkWall[i][j] == 0) && (checkWall[i - 1][j] == 0) && (checkWall[i][j - 1] == 0)) {
                    int a = house[i - 1][j - 1][0];
                    int b = house[i - 1][j - 1][1];
                    int c = house[i - 1][j - 1][2];

                    house[i][j][2] = a + b + c;
                }
            }
        }

        System.out.println(house[N][N][0] + house[N][N][1] + house[N][N][2]);
    }
}