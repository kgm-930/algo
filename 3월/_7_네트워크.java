class Solution {
    static boolean[] check;
    static int[][] staticComputers;
    static int answer = 0;
    static int n;

    public int solution(int N, int[][] computers) {
        n = N;
        check = new boolean[n];
        staticComputers = computers;

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                answer++;
                getNetwork(i);
            }
        }

        return answer;
    }

    private void getNetwork(int i) {
        for (int j = 0; j < n; j++) {
            if (check[j]) {
                continue;
            }

            if (staticComputers[i][j] == 1) {
                check[j] = true;
                getNetwork(j);
            }
        }
    }
}