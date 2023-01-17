import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    class info {
        int prio;
        boolean want;
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<info> print = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);

            info newInfo = new info();
            newInfo.prio = priorities[i];

            if (i == location) {
                newInfo.want = true;
            }

            print.offer(newInfo);
        }

        while (!print.isEmpty() && !pq.isEmpty()) {
            int priority = pq.peek();
            info info = print.poll();

            if (info.prio == priority) {
                pq.poll();
                answer++;

                if (info.want) {
                    return answer;
                }
            } else {
                print.offer(info);
            }
        }

        return answer;
    }
}