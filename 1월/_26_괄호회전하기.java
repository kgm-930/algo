import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    Queue<Character> queue = new LinkedList<>();
    static int answer = 0;
    static int len;

    public int solution(String s) {
        len = s.length();

        if (len % 2 == 1) {
            return 0;
        }

        for (int i = 0; i < len; i++) {
            queue.offer(s.charAt(i));
        }

        for (int i = 0; i < len; i++) {
            check();

            char ch = queue.poll();

            queue.offer(ch);
        }

        return answer;
    }

    private void check() {
        Stack<Character> stack = new Stack<>();
        Queue<Character> subQ = new LinkedList<>(queue);

        for (int i = 0; i < len; i++) {
            char character = subQ.poll();

            if (stack.empty()) {
                stack.add(character);
            } else {
                if (((character == ')') && (stack.peek() == '(')) || ((character == ']') && (stack.peek() == '[')) || ((character == '}') && (stack.peek() == '{'))) {
                    stack.pop();
                } else {
                    stack.add(character);
                }
            }
        }

        if (stack.size() == 0) {
            answer++;
        }
    }
}