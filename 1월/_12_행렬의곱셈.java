class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length;
        int b = arr1[0].length;
        int c = arr2[0].length;

        int[][] answer = new int[a][c];
        // 왼쪽 행렬 행 개수 만큼 반복
        for (int i = 0; i < a; i++) {
            //오른쪽 행렬 열 개수 만큼
            for (int j = 0; j < c; j++) {
                int sum = 0;

                // 왼쪽 행렬 열 개수 만큼
                for (int k = 0; k < b; k++) {
                    // 왼쪽 행렬의 행과 오른쪽 행렬의 열의 곱
                    answer[i][j]+= arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}