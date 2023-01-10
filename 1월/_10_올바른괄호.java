import java.util.Stack;

class Solution {
    Stack<Character> stack = new Stack<>();

    boolean solution(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        if (s.charAt(0) == ')') {
            return false;
        } else {
            stack.push(s.charAt(0));
        }

        for (int i = 1; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            }
        }

        return stack.empty();
    }
}