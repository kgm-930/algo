import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstString = br.readLine();
        String secondString = br.readLine();

        int[][] count = new int[firstString.length() + 1][secondString.length() + 1];

        for (int i = 1; i <= firstString.length(); i++) {
            for (int j = 1; j <= secondString.length(); j++) {
                count[i][j] = Math.max(count[i - 1][j], count[i][j - 1]);

                if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {
                    count[i][j] = count[i - 1][j - 1] + 1;
                }
            }
        }

        System.out.println(count[firstString.length()][secondString.length()]);
    }
}