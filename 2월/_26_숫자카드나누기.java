import java.util.ArrayList;
import java.util.Collections;

class Solution {
    ArrayList<Integer> array1 = new ArrayList<>();
    ArrayList<Integer> array2 = new ArrayList<>();
    int answer = 0;

    public int solution(int[] arrayA, int[] arrayB) {
        for (int num : arrayA) {
            array1.add(num);
        }

        for (int num : arrayB) {
            array2.add(num);
        }

        Collections.sort(array1);
        Collections.sort(array2);

        int numA = array1.get(0);
        int numB = array2.get(0);

        getFirst(numA, array1, array2);
        getFirst(numB, array2, array1);

        return answer;
    }

    private void getFirst(int num, ArrayList<Integer> array, ArrayList<Integer> otherArray) {
        for (int i = num; i >= 2; i--) {
            if (answer >= i) {
                return;
            }

            int count = 0;

            for (int getNum : array) {
                if (getNum % i == 0) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == array.size()) {
                getPossible(i, otherArray);
            }
        }
    }

    private void getPossible(int i, ArrayList<Integer> otherArray) {
        for (int num : otherArray) {
            if (num % i == 0) {
                return;
            }
        }

        answer = i;
    }
}