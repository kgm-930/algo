import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13_가장긴증가하는부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] count = new int[N];
        count[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;

        for (int i = 1; i < N; i++) {
            int max = 0;

            for (int j = 0; j <= i; j++) {
                if (array[i] > array[j]) {
                    max = Math.max(count[j], max);
                }
            }

            count[i] = max + 1;
            answer = Math.max(count[i], answer);
        }

        System.out.println(answer);
    }
}
