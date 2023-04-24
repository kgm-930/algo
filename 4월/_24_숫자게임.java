import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int AIndex = 0;

        for (int BNum : B) {
            int ANum = A[AIndex];

            if (BNum > ANum) {
                answer++;
                AIndex++;
            }
        }

        return answer;
    }
}