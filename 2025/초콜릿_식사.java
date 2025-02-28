import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 초콜릿_식사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int min = 1;
        int cut = 0;

        while (min < K) {
            min *= 2;
        }
        
        int remain = min; // 현재 초콜릿 크기

        while (K > 0) {
            if (K >= remain) {
                K -= remain; // 현재 크기만큼 사용
            } else {
                remain /= 2; // 절반으로 자르기
                cut++; // 자른 횟수 증가
            }
        }

        System.out.print(min + " " + cut);
    }
}
