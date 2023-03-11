import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));

        pq.addAll(Arrays.asList(routes));

        int last = -30001;

        while (!pq.isEmpty()) {
            int[] tunnel = pq.poll();

            if (tunnel[0] > last) {
                answer++;
                last = tunnel[1];
            }
        }

        return answer;
    }
}