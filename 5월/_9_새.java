import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9_새 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 1; i <= N;) {
            N -= i;

            answer++;

            i++;

            if (i > N) {
                i = 1;
            }
        }

        System.out.println(answer);
    }
}
