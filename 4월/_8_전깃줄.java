import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _8_전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        int lineCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= lineCount; i++) {
            st = new StringTokenizer(br.readLine());

            int[] connect = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            pq.add(connect);
        }

        int[][] lineInfo = new int[2][501];

        int ableLineCount = 0;

        while (!pq.isEmpty()) {
            int[] line = pq.poll();

            int A = line[0];
            int B = line[1];

            int max = 0;

            for (int i = 1; i <= A; i++) {
                if (B > lineInfo[0][i]) {
                    max = Math.max(max, lineInfo[1][i] + 1);
                }
            }

            ableLineCount = Math.max(ableLineCount, max);
            lineInfo[0][A] = B;
            lineInfo[1][A] = max;
        }

        System.out.println(lineCount - ableLineCount);
    }
}
