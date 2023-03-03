class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            int[] now = triangle[i];

            now[0] += triangle[i - 1][0];
            now[now.length - 1] += triangle[i - 1][i - 1];

            for (int j = 1; j < i; j++) {
                now[j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }

        int answer = 0;

        for (int num : triangle[triangle.length - 1]) {
            answer = Math.max(answer, num);
        }

        return answer;
    }
}