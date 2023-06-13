import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _13_Contact {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String ew = br.readLine();

            boolean check = false;

            PriorityQueue<String> pq = new PriorityQueue<>();

            if (ew.length() >= 2) {
                pq.add(ew);
            }

            while (!pq.isEmpty()) {
                String nowEw = pq.poll();

                if (nowEw.length() < 2) {
                    continue;
                }

                if (nowEw.charAt(0) == '0') {
                    if (nowEw.charAt(1) == '1') {
                        if (nowEw.length() == 2) {
                            check = true;
                            break;
                        } else {
                            String newEw = nowEw.substring(2);
                            pq.add(newEw);
                        }
                    }
                } else {
                    if (nowEw.length() >= 4) {
                        if ((nowEw.charAt(1) == '0') && (nowEw.charAt(2) == '0')) {
                            int index = 3;

                            boolean able = true;

                            for (; index < nowEw.length(); index++) {
                                if (nowEw.charAt(index) == '1') {
                                    break;
                                }

                                if ((index == nowEw.length() - 1) && (nowEw.charAt(index) == '0')) {
                                    able = false;
                                }
                            }

                            if (!able) {
                                continue;
                            }

                            for (; index < nowEw.length(); index++) {
                                if (nowEw.charAt(index) == '0') {
                                    break;
                                }

                                if ((index == nowEw.length() - 1) && (nowEw.charAt(index) == '1')) {
                                    check = true;
                                }
                            }

                            if (!check) {
                                pq.add(nowEw.substring(index));

                                if (nowEw.charAt(index - 2) != '0') {
                                    pq.add(nowEw.substring(index - 1));
                                }
                            }
                        }
                    }
                }
            }

            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
