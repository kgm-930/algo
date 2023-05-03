import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _3_약수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Long[] arr = new Long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(arr[0] * arr[N - 1]);
    }
}
