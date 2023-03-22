import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> subBelt = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            if (!subBelt.isEmpty()) {
                if (subBelt.peek() == order[answer]) {
                    subBelt.pop();
                    answer++;
                    i--;
                    continue;
                }
            }

            if (order[answer] == i) {
                answer++;
            } else {
                subBelt.add(i);
            }
        }

        while (!subBelt.isEmpty()) {
            int box = subBelt.pop();

            if (box == order[answer]) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}