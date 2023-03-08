import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            answer += Math.pow(work, 2);
            pq.add(work);
        }

        while (n != 0) {
            if (pq.isEmpty()) {
                return 0;
            }

            int num = pq.poll();

            answer -= Math.pow(num, 2);

            num--;
            n--;

            if (num != 0) {
                answer += Math.pow(num, 2);
                pq.add(num);
            }
        }

        return answer;
    }
}