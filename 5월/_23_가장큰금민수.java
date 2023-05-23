import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23_가장큰금민수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = N; i >= 4; i--) {
            String numToString = i + "";

            for (int j = 0; j < numToString.length(); j++) {
                int number = numToString.charAt(j) - '0';

                if ((number != 4) && (number != 7)) {
                    break;
                }

                if (j == numToString.length() - 1) {
                    System.out.println(numToString);
                    return;
                }
            }
        }
    }
}
