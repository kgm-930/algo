import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _21_명령프롬프트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String first = br.readLine();

        if (N == 1) {
            System.out.println(first);
            return;
        }

        char[] answer;

        answer = first.toCharArray();

        for (int i = 1; i < N; i++) {
            String fileName = br.readLine();

            for (int j = 0; j < fileName.length(); j++) {
                if (fileName.charAt(j) != answer[j]) {
                    answer[j] = '?';
                }
            }
        }

        for (char alphabet : answer) {
            System.out.print(alphabet);
        }
    }
}
