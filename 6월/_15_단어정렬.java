import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;

public class _15_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) != o2.charAt(i)) {
                        return (o1.charAt(i) - o2.charAt(i));
                    }
                }

                return (o1.charAt(0) - o2.charAt(0));
            } else {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < N; i++) {
            pq.add(br.readLine());
        }

        String preString = pq.poll();

        System.out.println(preString);

        while (!pq.isEmpty()) {
            String nowString = pq.poll();

            while (Objects.equals(preString, nowString)) {
                nowString = pq.poll();
            }

            if (nowString != null) {
                System.out.println(nowString);
            }

            preString = nowString;
        }
    }
}
