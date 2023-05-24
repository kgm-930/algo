import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _24_에너그램만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        Boolean[] word2Check = new Boolean[word2.length()];
        Arrays.fill(word2Check, false);

        int answer = word1.length() + word2.length();

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word2Check[j]) {
                    continue;
                }

                if (word1.charAt(i) == word2.charAt(j)) {
                    answer -= 2;

                    word2Check[j] = true;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
