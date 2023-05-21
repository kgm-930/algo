import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _19_하얀칸 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        for (int i = 0; i < 8; i++) {
            String st = br.readLine();

            for (int j = 0; j < 8; j++) {
                char cell = st.charAt(j);

                if (cell == '.') {
                    continue;
                }

                if (i % 2 == j % 2) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
