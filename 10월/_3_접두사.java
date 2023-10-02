import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _3_접두사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words;

        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());

        ArrayList<String> al = new ArrayList<>();

        al.add(words[0]);

        for (int i = 1; i < N; i++) {
            String word = words[i];

            for (int j = 0; j < al.size(); j++) {
                if (al.get(j).indexOf(word) == 0) {
                    break;
                }

                if (j == al.size() - 1) {
                    al.add(word);
                }
            }
        }

        System.out.println(al.size());
    }
}
