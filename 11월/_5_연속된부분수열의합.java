class Solution {
    public int[] solution(int[] sequence, int k) {
        boolean check = false;

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == k) {
                return new int[]{i, i};
            }
        }

        int[] answer;

        int head = 0;
        int tail = 0;

        int sum = sequence[0];

        int answerHead = -1;
        int answerTail = -1;

        while (head <= tail) {
            if (sum == k) {
                if (answerHead == -1) {
                    answerHead = head;
                    answerTail = tail;
                } else {
                    if ((answerTail - answerHead) > (tail - head)) {
                        answerHead = head;
                        answerTail = tail;
                    }
                }

                sum -= sequence[head++];
            } else if (sum > k) {
                sum -= sequence[head++];
            } else if (tail + 1 < sequence.length) {
                sum += sequence[++tail];
            } else {
                break;
            }
        }

        answer = new int[]{answerHead, answerTail};

        return answer;
    }
}