class Solution {
    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder(number);

        int count = 0;

        while (count != k) {
            for (int i = 0; i < sb.length() - 1; i++) {
                while (i >= 1) {
                    if ((sb.charAt(i - 1) < sb.charAt(i))) {
                        i--;
                    } else {
                        break;
                    }
                }

                if (sb.charAt(i) < sb.charAt(i + 1)) {
                    sb.deleteCharAt(i--);
                    count++;
                }

                if (count == k) {
                    break;
                }

                if ((i == sb.length() - 2) && (count == 0)) {
                    return sb.substring(0, sb.length() - k);
                }
            }
        }

        return sb.toString();
    }
}