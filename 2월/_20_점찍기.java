import java.util.HashSet;

class Solution {
    public long solution(long k, long d) {
        long answer = 0;

        for (long i = 0; i <= d; i += k) {
            long n = (long) Math.sqrt((d * d) - (i * i)) / k;
            answer += n + 1;
        }

        return answer;
    }
}