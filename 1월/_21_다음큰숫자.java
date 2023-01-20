import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;

        String targetBinary = Integer.toBinaryString(n);

        int targetOneCount = targetBinary.length() - targetBinary.replace("1", "").length();

        for (int i = n + 1; i < 10000000; i++) {
            String toBinary = Integer.toBinaryString(i);

            int zeroCount = toBinary.length() - toBinary.replace("1", "").length();

            if (zeroCount == targetOneCount) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}