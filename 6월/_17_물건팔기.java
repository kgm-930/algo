import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17_물건팔기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<long[]> al = new ArrayList<>();

        long cost = 0;
        long maxProfit = 0;

        long maxCost = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long pay = Integer.parseInt(st.nextToken());
            long del = Integer.parseInt(st.nextToken());

            if (del >= pay) {
                continue;
            }

            maxCost = Math.max(pay, maxCost);

            al.add(new long[]{pay, del});
        }

        for (long nowCost = maxCost; nowCost > 0; nowCost--) {
            long profit = 0;

            for (long[] customer : al) {
                if (nowCost <= customer[0]) {
                    if (nowCost > customer[1]) {
                        profit += nowCost - customer[1];
                    }
                }
            }

            if (profit >= maxProfit) {
                cost = nowCost;
                maxProfit = profit;
            }
        }

        System.out.println(cost);
    }
}
