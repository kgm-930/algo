class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder("");

        int[] XCount = new int[10];
        int[] YCount = new int[10];

        for (int i = 0; i < X.length(); i++) {
            XCount[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            YCount[Y.charAt(i) - '0']++;
        }

        boolean nonCheck = true;

        for (int i = 9; i >= 0; i--) {
            if (i == 0 && nonCheck && (XCount[i] == 0 || YCount[i] == 0)) {
                return "-1";
            }

            if (XCount[i] == 0 && YCount[i] == 0) {
                continue;
            } else if (i == 0 && nonCheck) {
                return "0";
            }

            for (int j = Math.min(XCount[i], YCount[i]); j > 0; j--) {
                answer.append(i);
                nonCheck = false;
            }
        }

        return answer.toString();
    }
}