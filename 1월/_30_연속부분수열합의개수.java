import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(int[] elements) {
        for (int i = 1; i <= elements.length; i++) {
            getSum(i, elements);
        }

        return set.size();
    }

    private void getSum(int len, int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int count = 0;
            int sum = 0;

            while (count != len) {
                int index = (i + count >= elements.length) ? (i + count - elements.length) : i + count;
                sum += elements[index];
                count++;
            }

            set.add(sum);
        }
    }
}