import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int m, int[] sections) {
        int answer = 0;

        int nowSection = 0;

        for (int section : sections) {
            if (section > nowSection) {
                nowSection = section + m - 1;
                answer++;
            }
        }

        return answer;
    }
}