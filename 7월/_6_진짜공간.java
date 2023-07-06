import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6_진짜공간 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer files = new StringTokenizer(br.readLine());

        long clusterSize = Long.parseLong(br.readLine());

        long answer = 0;

        for (int i = 0; i < N; i++) {
            long fileSize = Long.parseLong(files.nextToken());

            if (fileSize == 0) {
                continue;
            }

            if (fileSize % clusterSize == 0) {
                answer += fileSize;
            } else {
                answer += (fileSize / clusterSize + 1) * clusterSize;
            }
        }

        System.out.println(answer);
    }
}
