import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> APQ = new PriorityQueue<>();
        PriorityQueue<Integer> BPQ = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return 1;
            } else {
                return 0;
            }
        });

        for (int i = 0; i < A.length; i++) {
            APQ.offer(A[i]);
            BPQ.offer(B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            answer += APQ.poll() * BPQ.poll();
        }

        return answer;
    }
}