import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 게리멘더링 {
    static int N;
    static int[] people;
    static boolean[][] connect;
    static boolean[] selected;
    static int totalPopulation;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        people = new int[N + 1];
        connect = new boolean[N + 1][N + 1];
        selected = new boolean[N + 1];

        totalPopulation = 0;
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            totalPopulation += people[i];
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int connectionCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < connectionCount; j++) {
                int num = Integer.parseInt(st.nextToken());
                connect[i][num] = true;
                connect[num][i] = true;
            }
        }

        divide(1);

        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
    }

    private static void divide(int index) {
        if (index > N) {
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (selected[i]) {
                    groupA.add(i);
                } else {
                    groupB.add(i);
                }
            }

            if (groupA.isEmpty() || groupB.isEmpty()) {
                return;
            }

            if (isConnected(groupA) && isConnected(groupB)) {
                int populationA = getPopulation(groupA);
                int populationB = totalPopulation - populationA;
                minDifference = Math.min(minDifference, Math.abs(populationA - populationB));
            }
            return;
        }

        selected[index] = true;
        divide(index + 1);

        selected[index] = false;
        divide(index + 1);
    }

    private static boolean isConnected(List<Integer> group) {
        if (group.isEmpty()) {
            return false;
        }

        boolean[] visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int i = 1; i <= N; i++) {
                if (connect[node][i] && !visited[i] && group.contains(i)) {
                    visited[i] = true;
                    stack.push(i);
                    count++;
                }
            }
        }

        return count == group.size();
    }

    private static int getPopulation(List<Integer> group) {
        int sum = 0;
        for (int node : group) {
            sum += people[node];
        }
        return sum;
    }
}