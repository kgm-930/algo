import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4_전쟁전투 {
    static int N;
    static int M;
    static int power = 0;
    static int WPower = 0;
    static int BPower = 0;
    static char[][] battleField;
    static boolean[][] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        battleField = new char[M][N];
        check = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();

            battleField[i] = line.toCharArray();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    char color = battleField[i][j];

                    findAllies(i, j, color);

                    if (color == 'W') {
                        WPower += (power * power);
                    } else {
                        BPower += (power * power);
                    }

                    power = 0;
                }
            }
        }

        System.out.println(WPower + " " + BPower);
    }

    static void findAllies(int x, int y, char color) {
        if (!check[x][y]) {
            power++;

            check[x][y] = true;

            int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            for (int i = 0; i < 4; i++) {
                if ((x + dir[i][0] >= 0) && (x + dir[i][0] < M) && (y + dir[i][1] >= 0) && (y + dir[i][1] < N)) {
                    if (battleField[x + dir[i][0]][y + dir[i][1]] == color) {
                        findAllies(x + dir[i][0], y + dir[i][1], color);
                    }
                }
            }
        }
    }
}
