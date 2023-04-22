import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _22_기타줄 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int price = 0;

        int pa = Integer.MAX_VALUE;
        int si = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            pa = Math.min(Integer.parseInt(st.nextToken()), pa);
            si = Math.min(Integer.parseInt(st.nextToken()), si);
        }

        while (N != 0) {
            if (N < 6) {
                price += Math.min(pa, si * N);
                break;
            }

            price += Math.min(pa, si * 6);
            N -= 6;
        }

        System.out.println(price);
    }
}
