class Solution {
    static int need;
    static int reward;
    static int empty;
    static int answer = 0;

    public int solution(int a, int b, int n) {
        need = a;
        reward = b;
        empty = n;

        while (empty >= need) {
            answer += empty / need * reward;
            empty = empty % need + empty / need * reward;
        }

        return answer;
    }
}