import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] j) {
        int answer = 0;

        PriorityQueue<int[]> jobs = new PriorityQueue<>((Comparator.comparingInt(o -> o[0])));

        PriorityQueue<int[]> tasks = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));

        Collections.addAll(jobs, j);

        int time = 0;

        while (!(jobs.isEmpty() && tasks.isEmpty())) {
            if (!jobs.isEmpty()) {
                while (jobs.peek()[0] <= time) {
                    tasks.add(jobs.poll());

                    if (jobs.isEmpty()) {
                        break;
                    }
                }
            }

            if (tasks.isEmpty()) {
                assert jobs.peek() != null;
                time = jobs.peek()[0];
            } else {
                int[] temp = tasks.poll();
                answer += temp[1] + time - temp[0];
                time += temp[1];
            }
        }

        return answer * 10 / j.length / 10;
    }
}