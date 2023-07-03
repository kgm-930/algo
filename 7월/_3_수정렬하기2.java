import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _3_수정렬하기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            al.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(al);

        for (int num : al) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
