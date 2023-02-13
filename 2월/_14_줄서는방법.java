import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        k--;
        int[] answer = new int[n];

        List<Integer> list = new ArrayList<>();
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            list.add(i);
            fact *= i;
        }

        for (int i = 0; i < n; i++) {
            fact /= n - i;
            answer[i] = list.remove((int) (k / fact));
            k %= fact;
        }

        return answer;
    }
}