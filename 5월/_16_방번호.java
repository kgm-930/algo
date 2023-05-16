import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _16_방번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int[] numArr = new int[9];

        Arrays.fill(numArr, 1);
        numArr[6]++;

        int answer = 1;

        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';

            if (num == 9) {
                num = 6;
            }

            if (numArr[num] == 0) {
                for (int j = 0; j < 9; j++) {
                    numArr[j]++;
                }

                numArr[6]++;

                answer++;
            }

            numArr[num]--;
        }

        System.out.print(answer);
    }
}