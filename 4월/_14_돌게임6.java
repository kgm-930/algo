import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14_돌게임6 {
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());

        if ((n % 7 == 0) || (n % 7 == 2)) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
