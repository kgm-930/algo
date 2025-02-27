import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
    static int R;
    static int C;
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String string = br.readLine();

            for (int j = 0; j < C; j++) {
                board[i][j] = string.charAt(j) - 'A';
            }
        }

        boolean[] check = new boolean[26];
        check[board[0][0]] = true;

        findRoute(0, 0, 1, check.clone());

        System.out.print(answer);
    }

    private static void findRoute(int x, int y, int count, boolean[] check) {
        answer = Math.max(answer, count);
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < 4; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];

            if ((newX >= R) || (newX < 0) || (newY >= C) || (newY < 0)) {
                continue;
            }

            if (check[board[newX][newY]]) {
                continue;
            }

            boolean[] newCheck = check.clone();
            newCheck[board[newX][newY]] = true;

            findRoute(newX, newY, count + 1, newCheck);
        }
    }
}