import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> deck1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> deck2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> goalStack = new LinkedList<>(Arrays.asList(goal));

        while (!goalStack.isEmpty()) {
            String goalCard = goalStack.peek();

            if (Objects.equals(deck1.peek(), goalCard)) {
                deck1.poll();
                goalStack.poll();
            } else if (Objects.equals(deck2.peek(), goalCard)) {
                deck2.poll();
                goalStack.poll();
            } else {
                break;
            }
        }

        if (goalStack.size() == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }
}