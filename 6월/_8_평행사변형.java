import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _8_평행사변형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<double[]> spots = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            double[] spot = new double[2];

            spot[0] = Double.parseDouble(st.nextToken());
            spot[1] = Double.parseDouble(st.nextToken());

            spots.add(spot);
        }

        if ((spots.get(1)[0] - spots.get(0)[0]) * (spots.get(2)[1] - spots.get(1)[1]) ==
                (spots.get(1)[1] - spots.get(0)[1]) * (spots.get(2)[0] - spots.get(1)[0])) {
            System.out.println("-1");
            return;
        }

        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        double[] spot1 = spots.get(0);
        double[] spot2 = spots.get(1);
        double[] spot3 = spots.get(2);

        double para1 = Math.sqrt(Math.pow(spot1[0] - spot2[0], 2) + Math.pow(spot1[1] - spot2[1], 2))
                + Math.sqrt(Math.pow(spot1[0] - spot3[0], 2) + Math.pow(spot1[1] - spot3[1], 2));
        double para2 = Math.sqrt(Math.pow(spot2[0] - spot1[0], 2) + Math.pow(spot2[1] - spot1[1], 2))
                + Math.sqrt(Math.pow(spot2[0] - spot3[0], 2) + Math.pow(spot2[1] - spot3[1], 2));
        double para3 = Math.sqrt(Math.pow(spot3[0] - spot1[0], 2) + Math.pow(spot3[1] - spot1[1], 2))
                + Math.sqrt(Math.pow(spot3[0] - spot2[0], 2) + Math.pow(spot3[1] - spot2[1], 2));

        max = Math.max(Math.max(Math.max(max, para1), para2), para3);
        min = Math.min(Math.min(Math.min(min, para1), para2), para3);

        System.out.println(max * 2 - min * 2);
    }
}
