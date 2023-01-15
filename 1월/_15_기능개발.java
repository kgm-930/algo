import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> ans = new ArrayList<>();

    public Object[] solution(int[] progresses, int[] speeds) {
        Object[] answer = {};

        // 현재 위치
        int index = 0;

        while (index != progresses.length) {
            // 내놓을 개수
            int howMany = 0;

            // 얼마나 걸리는지
            int day = (int) Math.ceil(((double) 100 - progresses[index]) / speeds[index]);

            for (int i = index; i < progresses.length; i++) {
                progresses[i] += speeds[i] * day;
            }

            for (int i = index; i < progresses.length; i++) {
                if (progresses[i] >= 100) {
                    howMany++;
                } else {
                    break;
                }
            }

            index += howMany;
            ans.add(howMany);
        }

        answer = ans.toArray();

        return answer;
    }
}