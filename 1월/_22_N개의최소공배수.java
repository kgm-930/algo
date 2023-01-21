import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] arr) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            array.add(arr[i]);
        }

        Collections.sort(array);
        Collections.reverse(array);

        int answer = array.get(0);

        for (int i = 1; i < array.size(); i++) {
            int num = array.get(i);

            for (int j = 1; j < 100; j++) {
                if (answer * j % num == 0) {
                    answer *= j;
                    break;
                }
            }
        }

        return answer;
    }
}