import java.util.HashSet;

class Solution {
    HashSet<Integer> hs = new HashSet<>();

    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        int answer = -1;
        int count = 0;

        hs.add(x);

        while (!hs.isEmpty()) {
            if (hs.contains(y)) {
                return count;
            }

            HashSet<Integer> newHs = new HashSet<>();

            for (int num : hs) {
                int nextNum1 = num + n;
                int nextNum2 = num * 2;
                int nextNum3 = num * 3;

                if (nextNum1 <= y) {
                    newHs.add(nextNum1);
                }

                if (nextNum2 <= y) {
                    newHs.add(nextNum2);
                }

                if (nextNum3 <= y) {
                    newHs.add(nextNum3);
                }
            }

            hs = newHs;
            count++;
        }

        return answer;
    }
}