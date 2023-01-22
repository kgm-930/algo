class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (true) {
            int aCheck = (a % 2 == 0) ? a : a + 1;
            int bCheck = (b % 2 == 0) ? b : b + 1;

            if (Math.abs(aCheck / 2 - bCheck / 2) == 0) {
                break;
            }

            answer++;

            a = (a % 2 == 0) ? a : a + 1;
            b = (b % 2 == 0) ? b : b + 1;

            a /= 2;
            b /= 2;
        }

        return answer;
    }
}