import java.util.*;
import java.math.*;

class Solution {
    public int solution(int n) {
        int answer = 1;

        for (int i = 3; i <= n; i++) {
            boolean check = primeCheck(i);

            if (check) {
                answer++;
            }
        }

        return answer;
    }

    public boolean primeCheck(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}