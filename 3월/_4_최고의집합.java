import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        Arrays.fill(answer, s / n);

        int remain = s % n;

        for (int i = n - 1; i > 0; i--) {
            if (n - i == remain + 1) {
                break;
            }

            answer[i]++;
        }

        return answer;
    }
}