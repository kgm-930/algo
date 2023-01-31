class Solution {
    static boolean[] check;
    static int[][] dungeon;

    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dungeon = dungeons;

        action(k, 0, 0);

        return answer;
    }

    private void action(int stamina, int count, int clearCount) {
        if (count == dungeon.length) {
            answer = Math.max(answer, clearCount);
            return;
        }

        for (int i = 0; i < dungeon.length; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;

            if (stamina >= dungeon[i][0]) {
                action(stamina - dungeon[i][1], count + 1, clearCount + 1);
            } else {
                action(stamina, count + 1, clearCount);
            }

            check[i] = false;
        }
    }
}