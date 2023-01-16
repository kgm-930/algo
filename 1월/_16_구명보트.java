import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for(int x : people) {
            list.add(x);
        }
        
        Collections.sort(list);

        ArrayDeque<Integer> ad = new ArrayDeque<>(list);

        while (!ad.isEmpty()) {
            int kg = ad.pollLast();

            if ((!ad.isEmpty()) && (kg + ad.peekFirst() <= limit)) {
                ad.pollFirst();
            }

            answer++;
        }

        return answer;
    }
}