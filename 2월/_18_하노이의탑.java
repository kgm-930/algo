import java.util.LinkedList;
import java.util.Stack;

class Solution {
    LinkedList<int[]> answer = new LinkedList<>();

    public LinkedList<int[]> solution(int n) {
        hanoi(n, 1, 2, 3);

        return answer;
    }

    private void hanoi(int n, int a, int b, int c) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, a, c, b);
        answer.add(new int[]{a, c});
        hanoi(n - 1, b, a, c);
    }
}