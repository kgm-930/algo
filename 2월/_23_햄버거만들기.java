import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int ing : ingredient) {
            stack.add(ing);

            if (stack.size() >= 4) {
                int b1 = stack.pop();
                int m = stack.pop();
                int v = stack.pop();
                int b2 = stack.pop();

                if ((b1 == 1) && (m == 3) && (v == 2) && (b2 == 1)) {
                    answer++;
                } else {
                    stack.add(b2);
                    stack.add(v);
                    stack.add(m);
                    stack.add(b1);
                }
            }
        }

        return answer;
    }
}