import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1_보물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] arrA = new Integer[N];
        Integer[] arrB = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += arrA[i] * arrB[i];
        }

        System.out.println(answer);
    }
}
