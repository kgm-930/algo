import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2_토마토 {
    static BufferedReader br;
    static StringTokenizer st;
    static int M;
    static int N;
    static int[][] tomatoChest;
    static int needTomato;
    static int nowTomato = 0;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tomatoChest = new int[M][N];
        needTomato = M * N;
        fillTomato();

        if (needTomato == nowTomato) {
            System.out.println("0");
            return;
        }

        ripeTomato();

        if (needTomato != nowTomato) {
            System.out.println("-1");
        }
    }

    private static void ripeTomato() {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = tomato[0] + dir[i][0];
                int nextY = tomato[1] + dir[i][1];

                if ((nextX >= 0) && (nextX < M) && (nextY >= 0) && (nextY < N)) {
                    if (tomatoChest[nextX][nextY] == 0) {
                        nowTomato++;
                        tomatoChest[nextX][nextY] = 1;
                        queue.add(new int[]{nextX, nextY, tomato[2] + 1});
                    }
                }
            }

            if (nowTomato == needTomato) {
                System.out.println(tomato[2]);
                return;
            }
        }
    }

    private static void fillTomato() throws IOException {
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int nowSpace = Integer.parseInt(st.nextToken());

                if (nowSpace == 1) {
                    nowTomato++;
                    queue.add(new int[]{i, j, 1});
                } else if (nowSpace == -1) {
                    needTomato--;
                }

                tomatoChest[i][j] = nowSpace;
            }
        }
    }
}