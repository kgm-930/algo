class Solution {
    static int answer1 = 0;
    static int answer2 = 0;

    public int solution(int storey) {
        extracted(storey, true);
        extracted(storey, false);

        return Math.min(answer1, answer2);
    }

    private static void extracted(int storey, boolean oneOrTwo) {
        int answer = 0;

        while (storey > 0) {
            int stone = storey % 10;

            if (oneOrTwo) {
                if (stone > 5) {
                    stone = 10 - stone;
                    storey += 10;
                }
            } else {
                if (stone >= 5) {
                    stone = 10 - stone;
                    storey += 10;
                }
            }

            storey /= 10;
            answer += stone;
        }

        if (oneOrTwo) {
            answer1 = answer;
        } else {
            answer2 = answer;
        }
    }
}