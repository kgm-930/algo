import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class 학생_번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] students = new String[N];

        for (int i = 0; i < N; i++) {
            students[i] = br.readLine();
        }

        int answer = 0;

        while (true) {
            answer++;

            String[] num = new String[N];
            boolean check = false;

            for (int i = 0; i < N; i++) {
                num[i] = students[i].substring(students[i].length() - answer);
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (Objects.equals(num[i], num[j])) {
                        check = true;
                        break;
                    }
                }
            }

            if (!check) {
                break;
            }
        }

        System.out.print(answer);
    }
}
