import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10_오각형오각형오각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine()) - 1;

        long answer = 5;

        for (long i = 0; i < N; i++) {
            answer += 4;

            answer += (i + 1) * 3;
        }

        System.out.println(answer % 45678);
    }
}
