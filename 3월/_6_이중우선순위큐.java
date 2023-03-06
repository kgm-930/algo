import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        ArrayList<Integer> array = new ArrayList<>();

        for (String oper : operations) {
            StringTokenizer st = new StringTokenizer(oper);

            String firstCommand = st.nextToken();
            int secondCommand = Integer.parseInt(st.nextToken());

            if ((Objects.equals(firstCommand, "D")) && (array.isEmpty())) {
                continue;
            }

            if (Objects.equals(firstCommand, "I")) {
                array.add(secondCommand);
            } else {
                if (secondCommand == 1) {
                    array.remove(array.size() - 1);
                } else {
                    array.remove(0);
                }
            }

            Collections.sort(array);
        }

        if (array.isEmpty()) {
            return new int[]{0, 0};
        }

        int[] answer = new int[2];

        answer[0] = array.remove(array.size() - 1);
        answer[1] = array.remove(0);

        return answer;
    }
}