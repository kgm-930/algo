class Solution {
    int n;
    int[][] bridge;
    int answer = 0;
    boolean[] check;

    public int solution(int N, int[][] costs) {
        n = N;
        bridge = new int[n][n];
        check = new boolean[n];

        for (int[] cost : costs) {
            bridge[cost[0]][cost[1]] = cost[2];
            bridge[cost[1]][cost[0]] = cost[2];
        }

        check[0] = true;

        findRoute(0);

        return answer;
    }

    private void findRoute(int index) {
        int next = -1;
        int cost = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (check[i]) {
                continue;
            }

            if (bridge[index][i] == 0) {
                continue;
            }

            if (bridge[index][i] < cost) {
                next = i;
                cost = bridge[index][i];
            }
        }

        if (next != -1) {
            bridge[index][next] = 0;
            bridge[next][index] = 0;

            for (int i = 0; i < n; i++) {
                if (bridge[next][i] == 0) {
                    bridge[next][i] = bridge[index][i];
                } else if (bridge[index][i] == 0) {
                    continue;
                } else {
                    bridge[next][i] = Math.min(bridge[next][i], bridge[index][i]);
                }
            }

            answer += cost;
            check[next] = true;
            findRoute(next);
        }
    }
}