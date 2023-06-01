import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _1_저항 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> val = new HashMap<>();
        Map<String, Long> mul = new HashMap<>();

        val.put("black", 0L);
        val.put("brown", 1L);
        val.put("red", 2L);
        val.put("orange", 3L);
        val.put("yellow", 4L);
        val.put("green", 5L);
        val.put("blue", 6L);
        val.put("violet", 7L);
        val.put("grey", 8L);
        val.put("white", 9L);

        mul.put("black", 1L);
        mul.put("brown", 10L);
        mul.put("red", 100L);
        mul.put("orange", 1000L);
        mul.put("yellow", 10000L);
        mul.put("green", 100000L);
        mul.put("blue", 1000000L);
        mul.put("violet", 10000000L);
        mul.put("grey", 100000000L);
        mul.put("white", 1000000000L);

        long num = val.get(br.readLine()) * 10L + val.get(br.readLine());

        System.out.println(num * mul.get(br.readLine()));
    }
}
