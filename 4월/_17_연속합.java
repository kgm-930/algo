import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17_연속합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nowSum = Integer.parseInt(st.nextToken());
        int answer = nowSum;

        for (int i = 1; i < n; i++) {
            int nowNum = Integer.parseInt(st.nextToken());

            nowSum = Math.max(nowSum + nowNum, nowNum);
            answer = Math.max(nowSum, answer);
        }

        System.out.println(answer);
    }
}
