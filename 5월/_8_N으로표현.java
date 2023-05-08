import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[] repeatArr = {0, 1, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111};

    public int solution(int N, int number) {
        ArrayList<Set<Integer>> al = new ArrayList<>();

        if (N == number) {
            return 1;
        }

        for (int i = 1; i < 9; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = al.get(j - 1);
                Set<Integer> set2 = al.get(i - j - 1);

                for (int num1 : set1) {
                    for (int num2 : set2) {
                        set.add(num1 + num2);
                        set.add(num1 * num2);

                        set.add(num1 - num2);
                        set.add(num2 - num1);

                        if (num2 != 0) {
                            set.add(num1 / num2);
                        }

                        if (num1 != 0) {
                            set.add(num2 / num1);
                        }
                    }
                }
            }

            set.add(repeatArr[i] * N);
            al.add(set);
            
            if (set.contains(number)) {
                return i;
            }
        }

        return -1;
    }
}