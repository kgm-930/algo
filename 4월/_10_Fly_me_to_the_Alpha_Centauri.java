import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10_Fly_me_to_the_Alpha_Centauri {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            long distance = y - x;

            long answer = 0;

            for (int i = 1; distance > 0; i++) {
                distance -= i;
                answer++;

                if (distance <= 0) {
                    break;
                }

                distance -= i;
                answer++;
            }

            System.out.println(answer);
        }
    }
}
