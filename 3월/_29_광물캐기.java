import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] picks;
    static int pickCount = 0;
    static boolean[] pickCheck = new boolean[3];
    Queue<Integer> minerals;

    int answer = Integer.MAX_VALUE;

    public int solution(int[] p, String[] m) {
        picks = p;
        checkPicks();
        selectDig(m);

        return answer;
    }

    private void selectDig(String[] m) {
        for (int i = 0; i < 3; i++) {
            if (pickCheck[i]) {
                continue;
            }

            minerals = new LinkedList<>();
            convertToInt(m);

            dig(i, 0, 0);
        }
    }

    private void dig(int pick, int usedPickCount, int energy) {
        if (minerals.isEmpty()) {
            answer = Math.min(answer, energy);
            return;
        }

        usedPickCount++;

        picks[pick]--;

        if (picks[pick] == 0) {
            pickCheck[pick] = true;
        }

        int count = 0;

        while ((count != 5) && (!minerals.isEmpty())) {
            int mineral = minerals.poll();

            int pow = (pick > mineral) ? pick - mineral : 0;

            energy += (int) Math.pow(5, pow);

            count++;
        }

        if (usedPickCount == pickCount) {
            answer = Math.min(answer, energy);

            picks[pick]++;

            if (pickCheck[pick]) {
                pickCheck[pick] = false;
            }

            return;
        }

        int size = minerals.size();

        int[] newMinerals = new int[size];

        for (int i = 0; i < size; i++) {
            newMinerals[i] = minerals.poll();
        }

        for (int i = 0; i < 3; i++) {
            if (pickCheck[i]) {
                continue;
            }

            minerals = new LinkedList<>();

            for (int newMineral : newMinerals) {
                minerals.add(newMineral);
            }

            dig(i, usedPickCount, energy);
        }

        picks[pick]++;

        if (pickCheck[pick]) {
            pickCheck[pick] = false;
        }
    }

    private void convertToInt(String[] m) {
        for (String mineral : m) {
            if (mineral.equals("diamond")) {
                minerals.add(0);
            } else if (mineral.equals("iron")) {
                minerals.add(1);
            } else {
                minerals.add(2);
            }
        }
    }

    private void checkPicks() {
        for (int i = 0; i < 3; i++) {
            pickCount += picks[i];

            if (picks[i] == 0) {
                pickCheck[i] = true;
            }
        }
    }
}