class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        boolean[] lostArr = new boolean[31];
        boolean[] reserveArr = new boolean[32];

        for (int k : lost) {
            lostArr[k] = true;
        }

        for (int k : reserve) {
            reserveArr[k] = true;
        }

        for (int i = 1; i < 31; i++) {
            if (lostArr[i] & reserveArr[i]) {
                lostArr[i] = reserveArr[i] = false;
                answer++;
            }
        }

        for (int i = 1; i < 31; i++) {
            boolean small = lostArr[i] && reserveArr[i - 1];
            boolean big = lostArr[i] && reserveArr[i + 1];

            if (lostArr[i]) {
                if (i == 1) {
                    if (big) {
                        lostArr[i] = reserveArr[i + 1] = false;
                        answer++;
                    }
                } else {
                    if (small) {
                        lostArr[i] = reserveArr[i - 1] = false;
                        answer++;
                    } else if (big) {
                        lostArr[i] = reserveArr[i + 1] = false;
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}