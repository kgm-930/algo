import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19_쉽게푸는문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 1;

        int answer = 0;

        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= i; j++) {
                if (count >= A) {
                    answer += i;
                }

                count++;

                if (count > B) {
                    break;
                }
            }

            if (count > B) {
                break;
            }
        }

        System.out.println(answer);
    }
}
