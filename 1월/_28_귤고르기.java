import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        ArrayList<Integer> al = new ArrayList<>();

        for (int tang : tangerine) {
            al.add(tang);
        }

        al.sort(Collections.reverseOrder());

        int[] count = new int[al.get(0) + 1];

        for (int i = 0; i < al.size(); i++) {
            count[al.get(i)]++;
        }

        ArrayList<Integer> al2 = new ArrayList<>();

        for (int tangCount : count) {
            al2.add(tangCount);
        }

        al2.sort(Collections.reverseOrder());

        for (Integer integer : al2) {
            answer++;

            k -= integer;

            if (k <= 0) {
                return answer;
            }
        }

        return answer;
    }
}