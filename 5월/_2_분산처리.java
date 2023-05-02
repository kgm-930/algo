import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2_분산처리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) % 10;
            int b = Integer.parseInt(st.nextToken());

            int answer = a;

            for (int j = 0; j < b - 1; j++) {
                answer *= a;
                answer %= 10;
            }

            if (answer == 0) {
                System.out.println("10");
            } else {
                System.out.println(answer);
            }
        }
    }
}
