import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static long goal = 0;
    static long sum = 0;

    static Queue<Long> q1 = new LinkedList<>();
    static Queue<Long> q2 = new LinkedList<>();


    public int solution(int[] queue1, int[] queue2) {
        for (long num : queue1) {
            q1.add(num);
            goal += num;
            sum += num;
        }

        for (long num : queue2) {
            q2.add(num);
            goal += num;
        }

        if (goal % 2 == 1) {
            return -1;
        } else {
            goal /= 2;
        }

        for (int answer = 0; answer <= (q1.size() + q2.size()) * 2; answer++) {
            if (sum == goal) {
                return answer;
            } else {
                if (sum > goal) {
                    long num = q1.poll();

                    sum -= num;
                    q2.add(num);
                } else {
                    long num = q2.poll();

                    sum += num;
                    q1.add(num);
                }
            }
        }

        return -1;
    }
}