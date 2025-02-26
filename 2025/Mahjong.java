import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mahjong {
    static int[] hand = new int[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] answer = new boolean[10];

        for (int i = 0; i < 13; i++) {
            hand[Integer.parseInt(st.nextToken())]++;
        }

        // 치또이츠 선 확인
        if (sevenPairs() != -1) {
            answer[sevenPairs()] = true;
        }

        // 1 ~ 9 까지 화료 패 체크
        for (int i = 1; i <= 9; i++) {
            // 마작패는 최대 4개
            if (hand[i] == 4) {
                continue;
            }

            hand[i]++;

            // 머리 선택
            if (findHead()) {
                answer[i] = true;
            }

            hand[i]--;
        }

        boolean checkNone = true;

        for (int i = 1; i <= 9; i++) {
            if (answer[i]) {
                checkNone = false;
                System.out.print(i + " ");
            }
        }

        if (checkNone) {
            System.out.print("-1");
        }
    }


    // 머리 선택
    private static boolean findHead() {
        for (int i = 1; i <= 9; i++) {
            if (hand[i] >= 2) {
                hand[i] -= 2;

                // 몸통이 만들어지면 화료
                if (findBody(0)) {
                    hand[i] += 2;
                    return true;
                }

                hand[i] += 2;
            }
        }

        return false;
    }

    // 몸통
    private static boolean findBody(int bodyCount) {
        if (bodyCount == 4) {
            return true;
        }

        boolean checkPossible = false;

        // 커쯔 확인
        for (int i = 1; i <= 9; i++) {
            if (hand[i] >= 3) {
                hand[i] -= 3;

                checkPossible |= findBody(bodyCount + 1);

                hand[i] += 3;
            }
        }

        // 슌쯔 확인
        for (int i = 1; i <= 7; i++) {
            if ((hand[i] >= 1) && (hand[i + 1] >= 1) && (hand[i + 2] >= 1)) {
                hand[i]--;
                hand[i + 1]--;
                hand[i + 2]--;

                checkPossible |= findBody(bodyCount + 1);

                hand[i]++;
                hand[i + 1]++;
                hand[i + 2]++;
            }
        }

        return checkPossible;
    }

    // 치또이츠
    private static int sevenPairs() {
        // 치또이츠 카운트
        int count = 0;

        for (int i = 0; i < 10; i++) {
            if (hand[i] == 2) {
                count++;
            }
        }

        if (count == 6) {
            for (int i = 0; i < 10; i++) {
                if (hand[i] == 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
