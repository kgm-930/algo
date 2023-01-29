class Solution {
    static int answer = 0;

    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }

        String toKnum = sb.toString();
        StringBuilder cutNum = new StringBuilder();

        for (int i = 0; i < toKnum.length(); i++) {
            char num = toKnum.charAt(i);

            if (num == '0') {
                if (cutNum.length() != 0) {
                    checkPrime(Long.parseLong(cutNum.toString()));
                    cutNum = new StringBuilder();
                }
            } else {
                cutNum.append(num);
            }
        }

        if (cutNum.length() != 0) {
            checkPrime(Long.parseLong(cutNum.toString()));
        }

        return answer;
    }

    private void checkPrime(long x) {
        if (x == 1) {
            return;
        }

        if (x == 2) {
            answer++;
            return;
        }

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return;
            }
        }

        answer++;
    }
}