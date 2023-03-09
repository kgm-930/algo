import java.util.Objects;

class Solution {
    String begin;
    String target;
    String[] words;
    boolean[] check;

    int answer = Integer.MAX_VALUE;

    public int solution(String b, String t, String[] w) {
        begin = b;
        target = t;
        words = w;
        check = new boolean[words.length];

        changeWord(0);

        if (answer > 50) {
            return 0;
        } else {
            return answer;
        }
    }

    private void changeWord(int count) {
        if (count >= answer) {
            return;
        }

        if (Objects.equals(begin, target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (check[i]) {
                continue;
            }

            String now = begin;
            String next = words[i];

            if (canConvert(now, next)) {
                check[i] = true;
                begin = next;
                changeWord(count + 1);
                check[i] = false;
                begin = now;
            }
        }
    }

    private boolean canConvert(String now, String next) {
        int count = 0;

        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != next.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}