import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[] xy = {5, 5};
    static Set<String> set = new HashSet<>();

    public int solution(String dirs) {
        for (int i = 0; i < dirs.length(); i++) {
            char x = dirs.charAt(i);

            int action = 0;

            switch (x) {
                case 'D':
                    action = 1;
                    break;
                case 'R':
                    action = 2;
                    break;
                case 'L':
                    action = 3;
                    break;
            }

            control(action);
        }

        return set.size() / 2;
    }

    private void control(int action) {
        int newX = xy[0] + dir[action][0];
        int newY = xy[1] + dir[action][1];

        if ((newX >= 0) && (newX < 11) && (newY >= 0) && (newY < 11)) {
            String firstCase = xy[0] + "" + xy[1] + "" + newX + "" + newY;
            String secondCase = newX + "" + newY + "" + xy[0] + "" + xy[1];

            set.add(firstCase);
            set.add(secondCase);

            xy = new int[]{newX, newY};
        }
    }
}