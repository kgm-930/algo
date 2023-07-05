import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5_주사위 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());

        int[] sumCount = new int[S1 + S2 + S3 + 1];

        int answer = 3;
        int count = 0;

        for (int a = 1; a <= S1; a++) {
            for (int b = 1; b <= S2; b++) {
                for (int c = 1; c <= S3; c++) {
                    sumCount[a + b + c]++;

                    if (count < sumCount[a + b + c]) {
                        answer = a + b + c;
                        count = sumCount[a + b + c];
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
