import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] check = new boolean[n + 1];
        boolean[][] connection = new boolean[n + 1][n + 1];

        int nowGrade = 0;

        Queue<int[]> Q = new LinkedList<>();

        for (int[] getEdge : edge) {
            connection[getEdge[0]][getEdge[1]] = true;
            connection[getEdge[1]][getEdge[0]] = true;
        }

        check[1] = true;

        Q.add(new int[]{1, 1});

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                int[] nowNode = Q.poll();

                int grade = nowNode[0];
                int index = nowNode[1];

                if (grade > nowGrade) {
                    nowGrade = grade;
                    answer = 0;
                }

                if (grade == nowGrade) {
                    answer++;
                }

                for (int j = 1; j <= n; j++) {
                    if (check[j]) {
                        continue;
                    }

                    if (connection[index][j]) {
                        check[j] = true;
                        Q.add(new int[]{grade + 1, j});
                    }
                }
            }

            answer = size;
        }

        return answer;
    }
}