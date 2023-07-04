import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class _4_8진수2진수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        String oNum = br.readLine();

        if (Objects.equals(oNum, "0")) {
            System.out.println("0");
            return;
        }

        int length = oNum.length();

        for (int i = 0; i < length; i++) {
            answer.append(convertToBNum(oNum.charAt(i) - '0'));
        }

        while(answer.charAt(0) == '0'){
            answer = new StringBuilder(answer.substring(1));
        }

        System.out.println(answer);
    }

    private static String convertToBNum(int oNum) {
        String[] bArr = {"000", "001", "010", "011", "100", "101", "110", "111"};

        return bArr[oNum];
    }
}