import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _21_더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        int cycle = N;

        do {
            if (cycle < 10) {
                cycle = cycle * 10 + cycle;
            } else {
                int a = cycle % 10;
                int b = ((cycle / 10) + (cycle % 10)) % 10;

                cycle = a * 10 + b;
            }

            answer++;
        } while (N != cycle);

        System.out.println(answer);
    }
}
