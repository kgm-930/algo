import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 행운의_문자열 {
    static int[] alphabet = new int[26];
    static int stringLength;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();
        stringLength = string.length();

        for (int i = 0; i < stringLength; i++) {
            alphabet[string.charAt(i) - 'a']++;
        }

        findString(0, -1);

        System.out.print(count);
    }

    private static void findString(int nowLength, int previous) {
        if (nowLength == stringLength) {
            count++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if ((previous != i) && alphabet[i] >= 1) {
                alphabet[i]--;
                findString(nowLength + 1, i);
                alphabet[i]++;
            }
        }
    }
}
