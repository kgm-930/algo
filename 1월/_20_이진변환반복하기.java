import java.util.Objects;

class Solution {

    static int binCount = 0;
    static int zeroCount = 0;
    static String number;

    public int[] solution(String s) {
        number = s;

        while (!Objects.equals(number, "1")) {
            binCount++;
            removeZero();
            toBin();
        }

        return new int[]{binCount, zeroCount};
    }

    private void toBin() {
        number = Integer.toBinaryString(number.length());
    }

    private void removeZero() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0') {
                zeroCount++;
            } else {
                sb.append('1');
            }
        }

        number = sb.toString();
    }
}