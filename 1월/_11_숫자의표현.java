class Solution {
    public int solution(int n) {
        int answer = 1;
        int sum = 0;

        for (int i = 1; i <= n / 2; i++) {
            sum += i;
            System.out.print(i + " ");

            for (int j = i + 1; j <= n / 2 + 1; j++) {
                sum += j;
                System.out.print(j);

                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }

            sum = 0;
        }

        return answer;
    }
}