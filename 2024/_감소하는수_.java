import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _감소하는수_ {
    static ArrayList<Long> al = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(N);
        } else if (N > 1022) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < 10; i++) {
                makeNum(i, 1);
            }

            Collections.sort(al);

            System.out.println(al.get(N));
        }
    }

    static void makeNum(long num, int index) {
        if (index > 10) {
            return;
        }

        al.add(num);

        for (int i = 0; i < num % 10; i++) {
            makeNum(num * 10 + i, index + 1);
        }
    }
}
