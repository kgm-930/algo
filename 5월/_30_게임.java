import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30_게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = (long) Math.floor((double) Y * 100 / X);

        if ((X == Y) || (Z == 99)) {
            System.out.println("-1");
            return;
        }

        long one = (X * Z + X - 100 * Y);
        long two = 99 - Z;
        long answer = one / two;

        if (one % two == 0) {
            System.out.println(answer);
        } else {
            System.out.println(answer + 1);
        }
    }
}
