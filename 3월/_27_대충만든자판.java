import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                int needCount = hm.getOrDefault(key.charAt(i), 0);

                if (needCount == 0) {
                    hm.put(key.charAt(i), i + 1);
                } else {
                    hm.put(key.charAt(i), Math.min(needCount, i + 1));
                }
            }
        }

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;

            for (int j = 0; j < targets[i].length(); j++) {
                int needCount = hm.getOrDefault(targets[i].charAt(j), 0);

                if (needCount == 0) {
                    sum = -1;
                    break;
                } else {
                    sum += needCount;
                }
            }

            answer[i] = sum;
        }

        return answer;
    }
}