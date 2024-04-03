import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _운동_ {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int nowN = 0;
        int nowm = m;
        int time = 0;

        if ((nowm + T) > M) {
            System.out.println(-1);
            return;
        } else {
            while (N != nowN) {
                if ((nowm + T) <= M) {
                    nowN++;
                    nowm += T;
                } else {
                    if ((nowm - R) >= m) {
                        nowm -= R;
                    } else {
                        nowm = m;
                    }
                }

                time++;
            }
        }

        System.out.println(time);
    }
}
