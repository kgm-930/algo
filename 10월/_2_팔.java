import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2_팔 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        if (L.length() != R.length()) {
            System.out.println(0);
        } else {
            int answer = 0;

            for (int i = 0; i < L.length(); i++) {
                int LNum = L.charAt(i) - '0';
                int RNum = R.charAt(i) - '0';

                if (LNum == RNum) {
                    if (LNum == 8) {
                        answer++;
                    }
                } else {
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}
