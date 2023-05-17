import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (i < 100) {
                answer++;
            } else if (i < 1000) {
                int num1 = i / 100;
                int num2 = (i - num1 * 100) / 10;
                int num3 = i % 10;

                if ((num1 - num2) == (num2 - num3)) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
