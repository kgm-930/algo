import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _5_나누기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine()) / 100 * 100;

        long F = Long.parseLong(br.readLine());

        long answer = F - (N % F);

        if (answer == F) {
            System.out.println("00");
        } else if (answer < 10) {
            System.out.println("0" + answer);
        } else {
            System.out.println(answer);
        }
    }
}
