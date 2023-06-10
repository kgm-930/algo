import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10_적어도대부분의배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
        }

        for (int i = 3; i < Integer.MAX_VALUE; i++) {
            int count = 0;

            for (int j = 0; j < 5; j++) {
                if (i % arr[j] == 0) {
                    count++;
                }
            }

            if (count >= 3) {
                System.out.println(i);
                return;
            }
        }
    }
}
