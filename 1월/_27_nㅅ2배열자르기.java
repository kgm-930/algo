import java.util.ArrayList;

class Solution {
    public Object[] solution(int n, long left, long right) {
        ArrayList<Long> arrayList = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            arrayList.add(Math.max(i / n + 1, i % n + 1));
        }

        return arrayList.toArray();
    }
}