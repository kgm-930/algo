import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 그룹_단어_체커 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            checkGroupWord(string);
        }

        System.out.print(answer);
    }

    private static void checkGroupWord(String string) {
        boolean[] check = new boolean[26];

        check[string.charAt(0) - 'a'] = true;

        for (int i = 1; i < string.length(); i++) {
            if (!(string.charAt(i - 1) == string.charAt(i))) {
                if(check[string.charAt(i) - 'a']){
                    return;
                }
            }

            check[string.charAt(i) - 'a'] = true;
        }

        answer++;
    }
}
