import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        int count = 0;

        Map<Integer, Integer> gud = new HashMap<>();
        Set<Integer> ehd = new HashSet<>();

        for (int i = 0; i < topping.length; i++) {
            if (gud.get(topping[i]) == null) {
                count++;
                gud.put(topping[i], 1);
            } else {
                gud.put(topping[i], gud.get(topping[i]) + 1);
            }
        }

        for (int i = 0; i < topping.length; i++) {
            ehd.add(topping[i]);

            gud.put(topping[i], gud.get(topping[i]) - 1);

            if (gud.get(topping[i]) == 0) {
                count--;
            }

            if (count == ehd.size()) {
                answer++;
            }
        }

        return answer;
    }
}