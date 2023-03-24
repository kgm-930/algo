import java.util.PriorityQueue;

class Solution {
    static String[][] tickets;
    static int n;
    static boolean[] check;

    static PriorityQueue<String[]> pq;

    public String[] solution(String[][] t) {
        tickets = t;
        n = tickets.length;
        check = new boolean[n];

        pq = new PriorityQueue<>((o1, o2) -> {
            for (int i = 0; i < n; i++) {
                String s1 = o1[i];
                String s2 = o2[i];

                if (s1.compareTo(s2) < 0) {
                    return -1;
                } else if (s1.compareTo(s2) > 0) {
                    return 1;
                }
            }

            return 0;
        });

        for (int i = 0; i < n; i++) {
            if ("ICN".compareTo(tickets[i][0]) == 0) {
                String[] record = new String[n + 1];
                record[0] = "ICN";
                record[1] = tickets[i][1];


                check[i] = true;
                goNext(tickets[i][1], 1, record);
                check[i] = false;
            }
        }

        return pq.poll();
    }

    private void goNext(String start, int count, String[] record) {
        if (count == n) {
            pq.add(record);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i]) {
                continue;
            }

            if (start.compareTo(tickets[i][0]) == 0) {

                String[] newRecord = record.clone();
                newRecord[count + 1] = tickets[i][1];

                check[i] = true;
                goNext(tickets[i][1], count + 1, newRecord);
                check[i] = false;
            }
        }
    }
}