import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _6_정사각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st;
            ArrayList<int[]> al = new ArrayList<>();
            Map<Integer, Integer> length = new HashMap<>();

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());

                int[] spot = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

                al.add(spot);
            }

            int two = 0;
            int four = 0;

            for (int i = 0; i < 3; i++) {
                int[] spot1 = al.get(i);

                for (int j = i + 1; j < 4; j++) {
                    int[] spot2 = al.get(j);

                    int a = length.getOrDefault((int) (Math.pow(Math.abs(spot1[0] - spot2[0]), 2) + Math.pow(Math.abs(spot1[1] - spot2[1]), 2)), 0);

                    if (a == 0) {
                        length.put((int) (Math.pow(Math.abs(spot1[0] - spot2[0]), 2) + Math.pow(Math.abs(spot1[1] - spot2[1]), 2)), 1);
                    } else {
                        length.put((int) (Math.pow(Math.abs(spot1[0] - spot2[0]), 2) + Math.pow(Math.abs(spot1[1] - spot2[1]), 2)), a + 1);
                    }

                    if (length.get((int) (Math.pow(Math.abs(spot1[0] - spot2[0]), 2) + Math.pow(Math.abs(spot1[1] - spot2[1]), 2))) == 2) {
                        two++;
                    }

                    if (length.get((int) (Math.pow(Math.abs(spot1[0] - spot2[0]), 2) + Math.pow(Math.abs(spot1[1] - spot2[1]), 2))) == 4) {
                        four++;
                    }
                }
            }

            if ((two != 2) || (four != 1)) {
                System.out.println("0");
                continue;
            }

            System.out.println("1");
        }
    }
}
