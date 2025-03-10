import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 바이러스 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int connectCount = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Map<Integer, List<Integer>> connectionSet = new HashMap<>();

        for (int i = 0; i < connectCount; i++) {
            st = new StringTokenizer(br.readLine());

            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            connectionSet.putIfAbsent(nodeA, new ArrayList<>());
            connectionSet.putIfAbsent(nodeB, new ArrayList<>());
            connectionSet.get(nodeA).add(nodeB);
            connectionSet.get(nodeB).add(nodeA);
        }

        boolean[] check = new boolean[computer + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        check[1] = true;

        int answer = 0;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            List<Integer> nowConnection = connectionSet.getOrDefault(nowNode, Collections.emptyList());

            for (Integer integer : nowConnection) {
                if(!check[integer]){
                    answer++;
                    queue.add(integer);
                    check[integer] = true;
                }
            }
        }

        System.out.print(answer);
    }
}
