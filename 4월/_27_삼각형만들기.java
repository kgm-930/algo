import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class _27_삼각형만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < N - 2; i++) {
            if (arr[i] < (arr[i + 1] + arr[i + 2])) {
                System.out.println(arr[i] + arr[i + 1] + arr[i + 2]);
                return;
            }
        }

        System.out.println("-1");
    }
}
