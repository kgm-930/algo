import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 막대기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int answer = 0;

        // 1000000
        for (int i = 0; i < 7; i++) {
            if ((X & (1 << i)) != 0){
                answer++;
            }
        }

        System.out.print(answer);
    }
}
