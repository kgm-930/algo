import java.util.Stack;

class Solution {
    Stack<Character> stack = new Stack<>();

    public int solution(String s) {
        stack.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (stack.empty()) {
                stack.add(s.charAt(i));
            } else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }

        if (stack.empty()) {
            return 1;
        } else {
            return 0;
        }
    }
}