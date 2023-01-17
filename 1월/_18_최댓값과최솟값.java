import java.io.BufferedReader;
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(s);

        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());

            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        return min + " " + max;
    }
}