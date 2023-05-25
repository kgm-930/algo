import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25_피시방알바 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[101];

        Arrays.fill(check, false);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int seat = Integer.parseInt(st.nextToken());
            if (check[seat]) {
                answer++;
            } else {
                check[seat] = true;
            }
        }

        System.out.println(answer);
    }
}
