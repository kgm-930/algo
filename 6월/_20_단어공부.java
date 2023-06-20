import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();

        int[] charSet = new int[30];

        char answer = '?';

        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch -= 'A';
            } else {
                ch -= 'a';
            }

            charSet[ch]++;

            if (charSet[ch] > count) {
                count = charSet[ch];
                answer = (char) (ch + 'A');
            } else if (charSet[ch] == count) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}