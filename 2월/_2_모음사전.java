import java.util.*;

class Solution {
    static ArrayList<Character> stack = new ArrayList<>();
    static int answer = 0;
    static boolean check = false;

    public int solution(String word) {
        for (int i = 0; i < 1000000; i++) {
            answer++;

            if (stack.size() < 5) {
                stack.add('A');
            } else {
                stackPop();
            }

            compare(word);

            if (check) {
                return answer;
            }
        }

        return 0;
    }

    public void compare(String word) {
        StringBuilder now = new StringBuilder();

        for (Character character : stack) {
            now.append(character);
        }

        if (now.toString().compareTo(word) == 0) {
            check = true;
        }
    }

    public void stackPop() {
        char alpha = stack.remove(stack.size() - 1);

        switch (alpha) {
            case 'U':
                stackPop();
                return;
            case 'A':
                alpha = 'E';
                break;
            case 'E':
                alpha = 'I';
                break;
            case 'I':
                alpha = 'O';
                break;
            case 'O':
                alpha = 'U';
                break;
        }

        stack.add(alpha);
    }
}