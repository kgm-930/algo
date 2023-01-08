import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    String[] dis;

    public int solution(String[] want, int[] number, String[] discount) {
        // discount
        dis = discount;
        // Map 초기화
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        // 원래의 Map
        Map<String, Integer> oriMap = new HashMap<>(map);

        // 답
        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            answer += check(i);
            map = new HashMap<>(oriMap);
        }

        return answer;
    }

    private int check(int i) {
        for (int j = 0; j < 10; j++) {
            // 원하는 할인이면
            if (map.containsKey(dis[i + j])) {
                if (map.get(dis[i + j]) == 0) {
                    return 0;
                } else {
                    map.put(dis[i + j], map.get(dis[i + j]) - 1);
                }
            } else {
                return 0;
            }
        }

        return 1;
    }
}