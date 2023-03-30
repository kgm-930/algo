class Solution {
    public int solution(String s) {
        for (int answer = s.length(); answer > 0; answer--) {
            for (int startIndex = 0; startIndex + answer <= s.length(); startIndex++) {
                int head = startIndex;
                int tail = startIndex + answer - 1;

                if (checkAnswer(s, head, tail)) {
                    return answer;
                }
            }
        }

        return 0;
    }

    private boolean checkAnswer(String s, int head, int tail) {
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }

            head++;
            tail--;
        }

        return true;
    }
}