class Solution {
    public int solution(int n) {
        int pre = 0;
        int now = 1;

        for (int i = 1; i < n; i++) {
            int x = (pre + now) % 1234567;
            pre = now;
            now = x;
        }

        return now % 1234567;
    }
}