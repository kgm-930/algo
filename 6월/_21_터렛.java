import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21_터렛 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double r1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double r2 = Double.parseDouble(st.nextToken());

            double r3 = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

            if ((r3 == 0) && ((r1 == 0) && (r2 == 0))) {
                System.out.println("1");
            } else if ((r3 == 0) && (r1 == r2)) {
                System.out.println("-1");
            } else if ((r3 > Math.pow(r1 + r2, 2)) || (r3 < Math.pow(r1 - r2, 2))) {
                System.out.println("0");
            } else if ((r3 == Math.pow((r1 + r2), 2)) || (r3 == Math.pow(r1 - r2, 2))) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }
}
