import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _ACMCraft_ {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tCase = 0; tCase < T; tCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] time = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            Queue<int[]> queue = new LinkedList<>();
            int[] count = new int[N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;

                queue.offer(new int[]{X, Y});

                count[Y]++;
            }

            int[] sum = time.clone();

            while (!queue.isEmpty()) {
                int[] XY = queue.poll();

                int X = XY[0];
                int Y = XY[1];

                if (count[X] != 0) {
                    queue.offer(XY);
                } else {
                    count[Y]--;
                    sum[Y] = Math.max(sum[Y], sum[X] + time[Y]);
                }
            }

            System.out.println(sum[Integer.parseInt(br.readLine()) - 1]);
        }
    }
}
