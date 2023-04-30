import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> getRank = new HashMap<>();
        HashMap<Integer, String> getName = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            getRank.put(players[i], i);
            getName.put(i, players[i]);
        }

        for (String call : callings) {
            int rank = getRank.get(call);

            String loseName = getName.get(rank - 1);

            getRank.put(call, rank - 1);
            getRank.put(loseName, rank);
            getName.put(rank - 1, call);
            getName.put(rank, loseName);
        }

        String[] answer = new String[players.length];

        for (int i = 0; i < players.length; i++) {
            answer[i] = getName.get(i);
        }

        return answer;
    }
}