import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        answer[answer.length - 1] = -1;
        stack.add(numbers[answer.length - 1]);

        for (int i = answer.length - 2; i >= 0; i--) {
            int head = stack.peek();
            int num = numbers[i];

            if (head > num) {
                answer[i] = head;
                stack.add(num);
            } else if (head == num) {
                answer[i] = answer[i + 1];
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() > num) {
                        break;
                    }

                    stack.pop();
                }

                if (stack.isEmpty()) {
                    answer[i] = -1;
                } else {
                    answer[i] = stack.peek();
                }

                stack.add(num);
            }
        }

        return answer;
    }
}