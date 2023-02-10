import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
        String case1 = o1 + "" + o2;
        String case2 = o2 + "" + o1;

        return Integer.parseInt(case2) - Integer.parseInt(case1);
    }));

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        for (int number : numbers) {
            pq.add(number);
        }

        while (!pq.isEmpty()) {
            answer.append(pq.poll());
        }

        if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer.toString();
        }
    }
}