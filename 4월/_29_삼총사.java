class Solution {
    static int[] number;
    static boolean[] check;
    static int answer = 0;

    public int solution(int[] numbe) {
        number = numbe;
        check = new boolean[number.length];

        getThree(0, 0);

        return answer / 6;
    }

    private void getThree(int count, int sum) {
        if (count == 3) {
            if (sum == 0) {
                answer++;
            }

            return;
        }
        for (int i = 0; i < number.length; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;
            getThree(count + 1, sum + number[i]);
            check[i] = false;
        }
    }
}