import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 부호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 3; test_case++) {
            int N = Integer.parseInt(br.readLine());

            BigInteger S = new BigInteger("0");

            for (int i = 0; i < N; i++) {
                S = S.add(new BigInteger(br.readLine()));
            }

            BigInteger zero = new BigInteger("0");

            if (S.compareTo(zero) > 0) {
                System.out.println("+");
            } else if (S.compareTo(zero) == 0) {
                System.out.println("0");
            } else {
                System.out.println("-");
            }
        }
    }
}