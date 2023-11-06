class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int count = 0;

            if (i % Math.sqrt(i) == 0) {
                count++;
            }

            for (int j = 1; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    count += 2;
                }
            }

            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }

        return answer;
    }
}