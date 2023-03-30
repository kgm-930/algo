class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for (String bab : babbling) {
            bab = bab.replaceAll("ayaaya", "x");
            bab = bab.replaceAll("yeye", "x");
            bab = bab.replaceAll("woowoo", "x");
            bab = bab.replaceAll("mama", "x");

            bab = bab.replaceAll("aya", " ");
            bab = bab.replaceAll("ye", " ");
            bab = bab.replaceAll("woo", " ");
            bab = bab.replaceAll("ma", " ");
            bab = bab.replaceAll(" ", "");

            if (bab.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}