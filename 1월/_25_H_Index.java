import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> al = new ArrayList<>();

        for (int citation : citations) {
            al.add(citation);
        }

        Collections.sort(al);

        for (int h = al.size(); h >= 0; h--) {
            for (int i = 0; i < al.size(); i++) {
                if (al.get(i) >= h) {
                    if ((al.size() - i) >= h) {
                        return h;
                    }
                }
            }
        }

        return 0;
    }
}