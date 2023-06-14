import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        Integer[] newArr = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        Arrays.sort(newArr, Collections.reverseOrder());

        int removeNum = newArr[newArr.length - 1];

        Queue<Integer> q = new LinkedList<>();

        for (int num : arr) {
            if (num != removeNum) {
                q.add(num);
            }
        }

        int[] answer = new int[q.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }

        return answer;
    }
}