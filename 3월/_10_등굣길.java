class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] route = new int[m][n];

        for (int[] puddle : puddles) {
            route[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        route[0][0] = 1;

        for (int i = 1; i < m; i++) {
            if ((route[i][0] == -1) || (route[i - 1][0] == -1)) {
                route[i][0] = -1;
            } else {
                route[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if ((route[0][i] == -1) || (route[0][i - 1] == -1)) {
                route[0][i] = -1;
            } else {
                route[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (route[i][j] != -1) {
                    int up = route[i - 1][j];
                    int left = route[i][j - 1];

                    if ((up == -1) && (left == -1)) {
                        route[i][j] = -1;
                    } else if (up == -1) {
                        route[i][j] = left;
                    } else if (left == -1) {
                        route[i][j] = up;
                    } else {
                        route[i][j] = (up + left) % 1000000007;
                    }
                }
            }
        }

        if (route[m - 1][n - 1] == -1) {
            return 0;
        } else {
            return route[m - 1][n - 1];
        }
    }
}