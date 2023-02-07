import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int command = 0; command < commands.length; command++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            int i = commands[command][0];
            int j = commands[command][1];
            int k = commands[command][2];

            for (i -= 1; i < j; i++) {
                pq.add(array[i]);
            }

            for (int a = 0; a < k - 1; a++) {
                pq.poll();
            }

            answer[command] = pq.poll();
        }

        return answer;
    }
}