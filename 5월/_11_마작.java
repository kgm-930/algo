import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11_마작 {
    static int[] hand = new int[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 13; i++) {
            hand[Integer.parseInt(st.nextToken())]++;
        }

        int chiDdoi = -1;

        boolean[] answer = new boolean[10];

        // 치또이츠
        for (int i = 1; i <= 9; i++) {
            if (hand[i] == 1) {
                chiDdoi = i;
                continue;
            }

            if ((hand[i] != 2) && (hand[i] != 0)) {
                break;
            }

            if (i == 9) {
                answer[chiDdoi] = true;
            }
        }

        // 가능한지
        for (int i = 1; i <= 9; i++) {
            if (hand[i] == 4) {
                continue;
            }

            hand[i]++;

            // 머리
            for (int j = 1; j <= 9; j++) {
                if (hand[j] < 2) {
                    continue;
                }

                hand[j] -= 2;

                boolean able = chiPong();

                hand[j] += 2;

                if (able) {
                    answer[i] = true;
                    break;
                }
            }

            hand[i]--;

        }

        for (int i = 1; i <= 9; i++) {
            if (answer[i]) {
                break;
            }

            if (i == 9) {
                System.out.print(-1);
                return;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean chiPong() {
        for (int i = 1; i <= 9; i++) {
            if (hand[i] != 0) {
                break;
            }

            if (i == 9) {
                return true;
            }
        }

        // 퐁
        for (int i = 1; i <= 9; i++) {
            if (hand[i] == 3) {
                hand[i] -= 3;

                boolean able = chiPong();

                hand[i] += 3;

                if (able) {
                    return true;
                }
            }
        }

        // 치
        for (int i = 1; i <= 7; i++) {
            if ((hand[i] >= 1) && (hand[i + 1] >= 1) && (hand[i + 2] >= 1)) {
                hand[i]--;
                hand[i + 1]--;
                hand[i + 2]--;

                boolean able = chiPong();

                hand[i]++;
                hand[i + 1]++;
                hand[i + 2]++;

                if (able) {
                    return true;
                }
            }
        }

        return false;
    }
}
