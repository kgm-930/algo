import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] number;
    boolean[] check;
    Set<Integer> set = new HashSet<>();
    int answer = 0;

    public int solution(String numbers) {
        number = new int[numbers.length()];
        check = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            number[i] = numbers.charAt(i) - '0';
        }

        for (int i = 0; i < number.length; i++) {
            int card = number[i];

            if (card == 0) {
                continue;
            }

            check[i] = true;
            comb(card);
            comb(0);
            check[i] = false;
        }

        return answer;
    }

    private void comb(int cur) {
        if (cur == 0) {
            return;
        }

        int preSetSize = set.size();
        set.add(cur);

        if (preSetSize != set.size()) {
            checkPrime(cur);
        }

        for (int i = 0; i < number.length; i++) {
            if (check[i]) {
                continue;
            }

            int card = number[i];

            check[i] = true;
            comb(Integer.parseInt(cur + "" + card));
            comb(cur);
            check[i] = false;
        }
    }

    private void checkPrime(int num) {
        if(num == 1){
            return;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return;
            }
        }

        answer++;
    }
}