import java.util.*;

class Solution {

    static Queue<String> q = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 5;

        q.add(cities[0].toLowerCase());


        for (int i = 1; i < cities.length; i++) {
            boolean check = false;

            Queue<String> newQ = new LinkedList<>();

            String newCity = cities[i].toLowerCase();

            while (!q.isEmpty()) {
                String city = q.poll();

                if (city.compareTo(newCity) == 0) {
                    check = true;
                } else {
                    newQ.add(city);
                }
            }

            while (newQ.size() >= cacheSize) {
                newQ.poll();
            }

            newQ.add(newCity);

            q = newQ;

            if (check) {
                answer += 1;
            } else {
                answer += 5;
            }
        }

        return answer;
    }
}